# Liquibase

O Liquibase foi escolhido como a plataforma para administração de migrações e versionamento de banco de dados nos projetos de desenvolvimento da AEB.

Todo o processo é gerido através de arquivos conhecidos como changeLog (www.liquibase.org/documentation/databasechangelog.html). Para que o Liquibase execute é necessário que exista um changeLog no projeto. Este changeLog pode ser gerado automaticamente a partir de um banco pré-existente, de entidades de persistência do Hibernate ou à mão. O Liquibase irá então comparar o arquivo de changeLog com o banco de dados pré-existente, caso as mudanças não tenham sido aplicadas, o Liquibase automaticamente atualiza o banco. Internamente, o Liquibase utiliza de uma tabela no banco de dados com informações de quais mudanças foram executadas e de um lock, para administração do paralelismo entre clusters.

Obs. Uma vez que uma mudança é adicionada ao changeLog, esta nunca mais deve ser alterada, de modo a não ferir as expectativas do Liquibase, que mantém os dados de cada mudança em uma tabela no banco de dados, com um hash MD5 a partir de metadados da mudança. Qualquer alteração pode, então, bagunçar a tabela de changelogs.

[Configuração](#config)  
  
[Gerar o changeLog a partir de um banco](#cl_fromDb)  
[Gerar o changeLog a partir da diferença entre dois bancos](#cl_diff)  
[Inicializar um banco a partir do change log inicial](#cl_toDb)  
  
[Adicionar o Liquibase a um banco pré-existente](#cl_existingDb)  
[Atualizar o banco a partir das mudanças no Hibernate](#h_update)  

[Possíveis problemas](#problems)  
  
[Referência](#links)  

<a name="config"></a>
## Configuração

1. Adicione a dependência do Liquibase e plugins do Hibernate e Maven no arquivo pom.xml

	Ex:
	```
   <dependencies>
	<dependency>
		<groupId>org.liquibase</groupId>
		<artifactId>liquibase-core</artifactId>
	</dependency>
   </dependencies>
	...
   <plugins>
	<plugin>
		<groupId>org.liquibase</groupId>
		<artifactId>liquibase-maven-plugin</artifactId>
		<version>3.4.1</version>
		<configuration>
			<propertyFile>src/main/resources/liquibase.properties</propertyFile>
			<diffChangeLogFile>src/main/resources/db/changelog/db-changelog-${maven.build.timestamp}.xml</diffChangeLogFile>
		</configuration>
		<dependencies>
			<dependency>
				<groupId>org.liquibase.ext</groupId>
				<artifactId>liquibase-hibernate4</artifactId>
				<version>3.5</version>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-beans</artifactId>
				<version>4.1.7.RELEASE</version>
			</dependency>
			<dependency>
				<groupId>org.springframework.data</groupId>
				<artifactId>spring-data-jpa</artifactId>
				<version>1.7.3.RELEASE</version>
			</dependency>
			<dependency>
				<groupId>org.postgresql</groupId>
				<artifactId>postgresql</artifactId>
				<version>${postgresql.version}</version>
			</dependency>
			<dependency>
				<groupId>org.yaml</groupId>
				<artifactId>snakeyaml</artifactId>
				<version>1.17</version>
			</dependency>
		</dependencies>
	</plugin>
   </plugins>

	```

2. Crie um arquivo liquibase.properties com informações do banco. 

	Ex:
	```
	contexts = development
	changeLogFile = classpath:/db/changelog/liquibase-master-changeLog.xml
	outputChangeLogFile= src/main/resources/db/changelog/liquibase-master-changeLog.xml
	driver = org.postgresql.Driver
	url = jdbc:postgresql://localhost:5432/aebrh
	username = aebrh
	password = aebrh
	verbose = true
	dropFirst = false
	referenceUrl=hibernate:spring:aeb.gov.br.model?dialect=org.hibernate.dialect.PostgreSQLDialect&hibernate.namingStrategy=org.hibernate.cfg.ImprovedNamingStrategy
	```

3. Adicione o caminho para o changeLog no arquivo application.properties (Para projetos no SpringBoot)

	Ex:
	```
	liquibase.change-log=classpath:/db/changelog/liquibase-master-changeLog.xml
	```

4. Gere o arquivo de change Log Inicial

<a name="cl_fromDb"></a>
## Gerar o changeLog a partir de um banco pré-existente

1. Verifique se as informações do banco estão corretas no arquivo liquibase.properties

2. Execute o comando: 
	```
		mvn liquibase:generateChangeLog	
		mvn liquibase:generateChangeLog -Dliquibase.diffTypes=data
	```

Segundo a documentação, alguns detalhes podem não ser inseridos nesse processo, como funções especiais de um banco Oracle. Deve-se então verificar o arquivo após sua criação.

<a name="cl_diff"></a>
## Gerar o changeLog a partir da diferença entre dois bancos

1. Modifique o arquivo de configuração "liquibase.properties" para comparar com o banco de referência

	Ex:
	```
		referenceUrl=jdbc:postgresql://localhost:5432/outroBD
		referenceUsername=outroDbUsername
		referencePassword=outroDbPassword
	```

2. Gere o arquivo de changeLog pela diferença entre os dois (o arquivo será colocado no arquivo definido pela propriedade diffChangeLogFile)

	```
		mvn liquibase:diff
	```

<a name="cl_toDb"></a>
## Inicializar um banco a partir do change log inicial

1. Crie o arquivo de changeLog inicial com os valores a serem inseridos

2. Caso o banco possua restrições de chaves estrangeiras(muito provável), edite o arquivo de change log para desativar a verificação antes da inserção caso possível
	```
		<changeSet id="disable-keys" author="x" runAlways="true">
    			<sql>SET FOREIGN_KEY_CHECKS=0;</sql>
		</changeSet>
		...
		<changeSet id="enable-keys" author="x" runAlways="true">
    			<sql>SET FOREIGN_KEY_CHECKS=1;</sql>
		</changeSet>
	```
	ou coloque os comandos de adição de restrições de chaves ao final (PostgreSQL)

3. Execute o maven install


<a name="cl_existingDb"></a>
## Adicionar o Liquibase a um banco pré-existente

1. Crie o changelog inicial deste banco [Gerar o changeLog a partir de um banco](#cl_fromDb)

2. Adicione na tag "databaseChangeLog" do arquivo de changeLog o caminho para o changeLog definido no projeto SpringBoot.

	```
		logicalFilePath="classpath:/db/changelog/liquibase-master-changeLog.xml"
	```

3. Rode o liquibase com o comando changelogSync passando o caminho completo do arquivo de changeLog

	```
		mvn liquibase:changelogSync -Dliquibase.changeLogFile=src/main/resources/db/changelog/liquibase-master-changeLog.xml
	```

4. Remova o caminho que foi adicionado anteriormente na tag "databaseChangeLog", para evitar conflitos futuros

<a name="h_update"></a>
## Atualizar o banco a partir das mudanças no Hibernate

1. Modifique o arquivo de configuração "liquibase.properties" para comparar com as entidades de persistência do Hibernate

	Ex:
	```
		referenceUrl=hibernate:spring:org.hibernate.dialect.PostgreSQLDialect
	```

2. Gere o arquivo de changeLog pela diferença entre os dois (o arquivo será colocado no arquivo definido pela propriedade diffChangeLogFile)

	```
		mvn liquibase:diff
	```

3. Verifique que as mudanças estão de acordo com o esperado

4. Adicione o arquivo de changeLog ao final do changeLog master
	```
		<include file="path/db-{timestamp}.changelog.xml"/>
	```

5. Execute o maven install para atualizar o banco de dados

 
<a name="problems"></a>
## Possíveis Problemas 


<a name="p_liq_executing_twotimes"></a>
### Liquibase rodando a atualização duas vezes

	O Liquibase funciona verificando na tabela "databasechangelog" quais atualizações devem ser executadas. Caso o changeSet já tenha sido previamente executado, o funcionamento normal é que o mesmo não seja executado novamente. Erros nesse sentido, em que o Liquibase tenta rodar duas vezes a mesma atualização, podem ocorrer devido à confusão do Liquibase em identificar o changeSet na tabela, ou caso a tabela esteja vazia e as mudanças já realizadas no banco. 

1. A identificação do changeSet é feita a partir do id + author + filename. Caso algum desses valores tenha sido modificado, o Liquibase interpreta como um novo changeSet. Caso deseje resetar a tabela e inseri-la novamente

	```
		psql -U aebrh -h localhost
		TRUNCATE TABLE databasechangelog; 
	```


2. Caso a tabela esteja vazia, siga os passos descritos na seção de [inserir mudanças do changeLog em um banco pré existente](#cl_existingDb)


<a name="links"></a>
## Referência

#### Liquibase : http://www.liquibase.org/
#### Aprenda sobre changeLog : http://www.liquibase.org/documentation/databasechangelog.html
#### Integrando Maven com Liquibase e Hibernate :  













