#language: pt

Funcionalidade: logar
	Eu como usuario do site submarino
	Quero realizar login
	Para ter acesso as minhas informacoes

#Cenario positivo
Cenario: Realizar login
    Dado Que eu esteja na pagina do Submarino
    Quando acessar a pagina de login
    E inserir minhas informacoes
    E clicar em continuar
    Entao aparece a informacao 'Ola Nome'
    
#Cenario Negativo
Cenario: Realizar login falho
    Dado Que eu esteja na pagina do Submarino
    Quando acessar a pagina de login 
    E inserir minhas informacoes incorretas
    E clicar em continuar
    Entao aparece a mensagem 'E-mail ou senha incorretos'
    
