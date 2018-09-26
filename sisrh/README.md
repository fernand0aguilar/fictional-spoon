# AebRh

## O projeto

O aebRh é o backend do sistema de gerenciador de pessoas da AEB, ele é responsável por toda e qualquer interação dos sistemas com os dados dos funcionários.

## Preparando o ambiente

1. Download do repositório

  ```
  git clone https://newgit.aeb.gov.br/aeb/aebrh.git
  ```
2. Build e inicialização do sistema

  ```
  cd aebrh
  mvn spring-boot:run
  ```

## Release

Para realizar o build do sistema, é necessário ter o git instalado no sistema assim como o maven, e executar o seguinte comando na pasta raiz:

```
  mvn clean
  mvn release:prepare
```

Este comando irá automáticamente alterar as versões dos projetos no pom, executar os testes, criar uma tag no git e dar push na mesma.
