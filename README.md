# Projeto Login Submarino

Projeto de automação desenvolvido para realizar login na área do cliente do site Submarino.

## Tecnologias

Foi utilizado as seguintes tecnologias para o desenvolvimento:

* [Eclipse] - IDE.
* [Java] - Linguagem de programação.
* [Selenium] - Framework para automação web.
* [Junit] - Framework de testes.
* [BDD - Behavior Driven Development] - Metodologia de desenvolvimento de testes dirigida a comportamento.
* [Cucumber] - Framework de tradução de linguagem Gherkin para métodos. 
* [YAML] - Formato de codificação de dados legíveis por humanos.

## Tratamento utilizado para o Captcha
 Sobre o tratamento do captcha, foi criado um método chamado **aguardarRealizarCaptcha** que cria uma tela com a mensagem **"Por favor, preencha o captcha e depois clique no botão 'OK' para continuar"** e um botão OK.

## Criação dos Cenarios

Os Cenarios foram criados utilizando a metodologia BDD, escritos na linguagem Gherkin e transformados em métodos pelo framework Cucumber.

## YAML

Foi utilizado o formato de dados *YAML* para guardar os elementos das páginas e utilizado a classe **SubmarinoPage** para criar os acessos dos elementos do arquivo YAML.

## Execução

Para realizar os testes, foi criado o arquivo executor.

```
executor.java
```
License
----

MIT

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[Java]: <https://www.java.com/en/>
[Eclipse]:<https://www.eclipse.org/>
[Selenium]:<https://www.seleniumhq.org/>
[Junit]: <https://junit.org/junit5/>
[BDD - Behavior Driven Development]: <https://cucumber.io/docs/guides/bdd-tutorial/>
[Cucumber]: <https://cucumber.io/>
[YAML]: <https://yaml.org/>
