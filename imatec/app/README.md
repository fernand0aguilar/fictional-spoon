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
    gulp finalBuild
    ```

3. Start do servidor

    ```
    node server/app.js
    ```
    
#### Deploy

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


