Feature: logar
	Eu como usuario do site submarino
	Quero realizar login
	Para ter acesso as minhas informacoes

#Cenario positivo
Scenario: Realizar login
    Given Que eu esteja na pagina do Submarino
    When acessar a pagina de login 
    And inserir minhas informacoes
    And clicar em continuar
    Then aparece a informacao 'Ola Nome'
    
#Cenario Negativo
Scenario: Realizar login falho
    Given Que eu esteja na pagina do Submarino
    When acessar a pagina de login 
    And inserir minhas informacoes incorretas
    And clicar em continuar
    Then aparece a mensagem 'E-mail ou senha incorretos'
    
