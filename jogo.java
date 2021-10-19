import java.util.Scanner;

public class jogo {
    public static void main(String[] args) {
        int respostaDificuldade = 0;
        int respostaJogador = 0;
        int respostaCarta = 1;
        int qntdBaralho = 1;
        int jogador1 = 0;
        int jogador2 = 0;

        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("=======================================");
            System.out.println(" SEJAM BEM-VINDOS AO JOGO BLAJACK (21)");
            System.out.println("=======================================");
            System.out.println("Informe com quem deseja jogar: ");
            System.out.println("[1] Contra o Computador | [2] Contra um amigo");
            respostaJogador = entrada.nextInt();

        } while (respostaJogador != 1 && respostaJogador != 2);

        do {
            System.out.println("==============================================");
            System.out.println("Legal! Agora escolha o nível de dificuldade: ");
            System.out.println("==============================================");
            System.out.println("[1] Fácil - 1 Baralho");
            System.out.println("[2] Médio - 3 Baralhos");
            System.out.println("[3] Difícil - 8 Baralhos");
            System.out.println("[4] Personalizar quantidade");
            respostaDificuldade = entrada.nextInt();
        } while (respostaDificuldade <= 0 || respostaDificuldade >= 5);

        switch (respostaDificuldade) {
            case 1:
                qntdBaralho = 1;
                break;
            case 2:
                qntdBaralho = 3;
                break;
            case 3:
                qntdBaralho = 8;
                break;
            case 4:
                System.out.println("=======================================");
                System.out.print("Digite com quantos baralhos quer jogar: ");
                qntdBaralho = entrada.nextInt();
        }

        baralho b = new baralho(qntdBaralho);
        System.out.println("=============================================");
        System.out.println("Você irá jogar com " + b.quantidadeCartas + " cartas.");
        System.out.println("Vamos começar e boa sorte!");

        switch (respostaJogador) {
            case 1:
                System.out.println("===========================================================");
                System.out.println("Agora é a vez JOGADOR 1: ");

                b.gerarCartas();
                b.embaralharDeck();

                System.out.println("===========================================================");
                System.out.println("Seu baralho foi embaralhado! Aqui está sua primeira carta:");

                while (respostaCarta == 1) {
                    String carta = b.pegarCarta();
                    System.out.println("===========================================================");
                    System.out.println("Pontos total: " + b.pontos(carta));

                    if (b.pontuacaoAtual > 21) {
                        respostaCarta = 2;
                    } else {
                        System.out.println("Deseja pegar mais uma carta? [1] SIM | [2] NÃO ");
                        respostaCarta = entrada.nextInt();
                    }

                    System.out.println("===========================================================");
                    System.out.println("Pontuação do JOGADOR 1 foi: " + b.pontuacaoAtual);
                    jogador1 = b.pontuacaoAtual;
                }

                System.out.println("===========================================================");
                System.out.println("Agora é a vez do computador (JOGADOR 2): ");

                respostaCarta = 1;
                b.deck.reset();
                b.pontuacaoAtual = 0;
                b.pontuacaoInicial = 0;
                b.gerarCartas();
                b.embaralharDeck();

                while (respostaCarta == 1) {
                    String carta = b.pegarCarta();
                    System.out.println("===========================================================");
                    System.out.println("Pontos total: " + b.pontos(carta));

                    if (b.pontuacaoAtual >= 21) {
                        respostaCarta = 2;
                    } else {
                        System.out.println("Deseja pegar mais uma carta? [1] SIM | [2] NÃO ");
                        respostaCarta = 1;
                    }
                }
                System.out.println("===========================================================");
                System.out.println("Pontuação do Computador: " + b.pontuacaoAtual);
                jogador2 = b.pontuacaoAtual;

                System.out.println("===========================================================");
                System.out.println(b.validarGanhador(jogador1, jogador2));

                break;
            case 2:
                System.out.println("===========================================================");
                System.out.println("Agora é a vez JOGADOR 1: ");

                b.gerarCartas();
                b.embaralharDeck();

                System.out.println("===========================================================");
                System.out.println("Seu baralho foi embaralhado! Aqui está sua primeira carta:");

                while (respostaCarta == 1) {
                    String carta = b.pegarCarta();
                    System.out.println("===========================================================");
                    System.out.println("Pontos total: " + b.pontos(carta));

                    if (b.pontuacaoAtual > 21) {
                        respostaCarta = 2;
                    } else {
                        System.out.println("Deseja pegar mais uma carta? [1] SIM | [2] NÃO ");
                        respostaCarta = entrada.nextInt();
                    }
                }

                System.out.println("===========================================================");
                System.out.println("Pontuação do JOGADOR 1 foi: " + b.pontuacaoAtual);
                jogador1 = b.pontuacaoAtual;

                System.out.println("===========================================================");
                System.out.println("Agora é a vez do JOGADOR 2: ");

                respostaCarta = 1;
                b.deck.reset();
                b.pontuacaoAtual = 0;
                b.pontuacaoInicial = 0;
                b.gerarCartas();
                b.embaralharDeck();

                while (respostaCarta == 1) {
                    String carta = b.pegarCarta();
                    System.out.println("===========================================================");
                    System.out.println("Pontos total: " + b.pontos(carta));

                    if (b.pontuacaoAtual > 21) {
                        respostaCarta = 2;
                    } else {
                        System.out.println("Deseja pegar mais uma carta? [1] SIM | [2] NÃO ");
                        respostaCarta = entrada.nextInt();
                    }
                }
                System.out.println("===========================================================");
                System.out.println("Pontuação do JOGADOR 2 foi: " + b.pontuacaoAtual);
                jogador2 = b.pontuacaoAtual;

                System.out.println("===========================================================");
                System.out.println(b.validarGanhador(jogador1, jogador2));

        }

        entrada.close();

    }
}
