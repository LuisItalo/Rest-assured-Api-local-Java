# Rest-assured-Api-local-Java

Projeto de automação de testes web, maven, com os seguintes recursos:

- Java;
- Maven;
- RestAssured;
- Junit;
- Selenium;
- Cucumber (BDD);
- Padrão Page Objects

**Avisos Importantes**

Os teste foram validados na minha maquina pessoal.

## Dependencias e Plugins

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.5.1</version> <!-- Use a versão mais recente -->
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-path</artifactId>
            <version>4.5.1</version> <!-- Use a versão mais recente -->
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.9.1</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>6.9.1</version>
        </dependency>

## Planejamento dos Testes

~~~gherkin
@get
  Cenário: Obter um cliente existente
    Dado que a URI base é configurada
    Quando eu enviar uma requisição GET para obter o cliente em "/api/clientes/4"
    Então o código de resposta no GET deve ser 200
    E a resposta deve conter informações do cliente

  @post
  Cenário: Criar um novo cliente
    Dado que a URI base é configurada
    E o corpo da requisição POST é configurado
    Quando eu enviar uma requisição POST para criar um cliente em "/api/clientes"
    Então o código de resposta no POST deve ser 201
    E a resposta deve conter o ID do cliente criado

  @put
  Cenário: Atualizar informações de um cliente
    Dado que a URI base é configurada
    E o corpo da requisição PUT é configurado
    Quando eu enviar uma requisição PUT para atualizar o cliente em "/api/clientes/4"
    Então o código de resposta deve ser 200
    E a resposta deve conter informações atualizadas do cliente


  @delete
  Cenário: Excluir um cliente
    Dado que a URI base é configurada
    Quando eu enviar uma requisição DELETE para excluir o cliente em "/api/clientes/4"
    Então a resposta deve ser 204
~~~ 
## Iniciar o Teste
Para rodar o teste, criei uma pasta **runners** onde contem uma classe **RunCucumberTests** 
> /home/luis/Java-Code/teste-api-local/src/test/java/runners/RunCucumberTests.java

e selecionei a tag de acordo com a necessidade

~~~
@CucumberOptions(
features = "src/test/resources/features",
glue = "steps",
plugin = {"pretty", "html:target/report-cucumber.html"},
tags = "@delete"
~~
