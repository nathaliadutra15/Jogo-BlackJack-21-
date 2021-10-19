# JOGO BLACKJACK (21) EM JAVA - UTILIZANDO LISTA DINÂMICA E PILHA ESTÁTICA 

Jogo 21 implementado em JAVA, utilizando conceitos de programação orientada a objetos e estrutura de dados. Basicamente, o jogo consiste em juntar 21 pontos com as cartas do baralho. Nesta versão, é possível que:

 * O jogador jogue com o computador ou com um amigo;
 * O jogador escolha com quantos baralhos deseja jogar (com as quantidades já pré-definidas ou personalizá-las);
 
As regras do jogo foram verificadas no site https://pt.wikipedia.org/wiki/Blackjack, porém, houveram adaptações:
 * O jogador pode escolher em jogar com mais de 8 baralhos;
 * O jogador pode retirar as cartas da pilha enquanto não atingir 21 (sem limitações de até 5 cartas retiradas);
 * O jogador pode optar em parar de retirar as cartas com menos de 17 pontos;
 * Caso os dois jogadores não tenham atingido 21 pontos, ganha o jogador com menos pontos;
 * Cartas com valor de "Às" poderão valer 1 ponto caso o jogador possua 20 pontos acumulados e 11 pontos caso o jogador possua menos de 11 pontos acumulados;
