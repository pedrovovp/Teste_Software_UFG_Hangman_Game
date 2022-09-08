@tag
Feature: Teste do Jogo da Forca (Hangman)
  Funcionalidades da classe Game.java

  @tag1
  Scenario: jogador adivinha a palavra "teste" e vence o jogo
    Given o jogo recebe a palavra "teste" para ser adivinhada
    When o jogador insere a letra "t"
    Then o jogo exibe seu estado: 6 tentativas restantes para resolver: "t--t-"
    When o jogador insere a letra "t"
    Then o jogo informa que a letra ja foi adivinhada
    When o jogador insere a letra "e"
    Then o jogo exibe seu estado: 6 tentativas restantes para resolver: "te-te"
    When o jogador insere a letra "1"
    Then o jogo pede para que o jogador envie uma letra
    When o jogador insere a letra ""
    Then o jogo informa que nenhuma letra foi enviada
    When o jogador insere a letra "s"
    Then O jogador vence o jogo, com 6 tentativas restantes

  @tag2
  Scenario: jogador não consegue adivinhar a palavra "teste" e perde o jogo
    Given o jogo recebe a palavra "teste" para ser adivinhada
    When o jogador insere a letra 'l'
    Then o jogo exibe seu estado: 5 tentativas restantes para resolver: "-----"
    When o jogador insere a letra 't'
    Then o jogo exibe seu estado: 5 tentativas restantes para resolver: "t--t-"
    When o jogador insere a letra 'k'
    Then o jogo exibe seu estado: 4 tentativas restantes para resolver: "t--t-"
    When o jogador insere a letra 'j'
    Then o jogo exibe seu estado: 3 tentativas restantes para resolver: "t--t-"
    When o jogador insere a letra 'h'
    Then o jogo exibe seu estado: 2 tentativas restantes para resolver: "t--t-"
    When o jogador insere a letra 'g'
    Then o jogo exibe seu estado: 1 tentativas restantes para resolver: "t--t-"
    When o jogador insere a letra 'f'
    Then O jogador perde o jogo
