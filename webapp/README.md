# aebRh webapp

### O projeto

Projeto em angularJs para servir de interface de usuário para o cliente do aebRh.

#### Tecnologias

* AngularJS
* Angular Material
* NodeJS
* npm
* bower
* gulp

#### Preparação do ambiente

1. Download do repositório
    
    ```
    git clone https://newgit.aeb.gov.br/aebrh/webapp.git
    cd webapp
    ```

2. Download das dependencias
    
    ```
    npm install
    bower install
    ```
    
3. Configurar localmente

    Para selecionar as configurações, criar um arquivo .env na raiz do Projeto
    
    ```
    vim .env
    ```

    Adicione as seguintes configurações:
        
    ```
    expressUrl=http://localhost:9000/
    host=http://localhost:8080
    context=/api/
    enableDebug=true
    ```
    
4. Monitorar as mudanças

    ```
    gulp watch
    ```
5. Build

    ```
    gulp finalBuild
    ```

6. Start do servidor

    ```
    node server/app.js
    ```

#### Deploy
Antes de fazer deploy é necessário dar build no servidor

```
gulp finalBuild
```

Para realizar o deploy execute o comando

```
gulp release
```

Este comando irá alterar a versão patch do projeto:

```
0.0.0 -> 0.0.1
```

Caso seja necessário alterar a versão minor o comando se torna:

```
gulp release --type minor
```
    
Com o resultado de:

```
0.0.1 -> 0.1.0
```
    
E por último caso seja uma versão major:

```
gulp release --type major
```
    
Com o resultado de:

```
0.1.0 -> 1.0.0
```

Estes comandos irão criar uma tag no git e dar commit na mesma, sendo assim é necessário que as mudanças que foram executadas sejam comitadas antes de executar.

