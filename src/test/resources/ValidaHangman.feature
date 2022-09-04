#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Teste do Jogo da Forca (Hangman)
	Funcionalidades da classe Game.java

	@tag1
	Scenario: partida de jogo da forca com dois jogadores
	Given eu insiro uma palavra <palavra> para o outro jogador adivinhar
	When ele insere varias letras <letras>,
	Then recebemos um retorno <resolvida> <tentativasRestantes>

		Examples:
			| palavra | letras | resolvida | tentativasRestantes |
			| "resposta" | "respota" | true | 6 | 
			| "世界" | "セ界世" | true | 5 |
			| "resposta" | "reoicnamlk" | false | 0 |
			| "resposta" | "reoicnamlkq" | false | -1 |
			| "resposta" | "respot" | false | 6 |
		