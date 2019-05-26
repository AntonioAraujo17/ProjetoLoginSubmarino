#Author: Antonio Araujo
#language: pt

Funcionalidade: Logar como cliente no site de compras Submarino
	Eu como usuario do site submarino
	Quero realizar login no sistema de clientes
	Para ter acesso as minhas informações

#Cenario positivo
Cenario: Logar na área do cliente com credencias corretas
    Dado que eu esteja na página inicial do Submarino
    Quando acessar a página de login
    E preencher minhas informações corretas
    E clicar em continuar
    Entao aparece a informação 'Ola' seguido de um nome escolhido pelo cliente
    
#Cenario Negativo
Cenario: Logar na área do cliente com credencias erradas
    Dado que eu esteja na página inicial do Submarino
    Quando acessar a página de login 
    E preencher minhas informações incorretas
    E clicar em continuar
    Entao aparece a mensagem 'E-mail ou senha incorretos'
