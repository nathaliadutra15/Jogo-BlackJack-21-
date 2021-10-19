import java.util.ArrayList;
import java.util.Collections;

public class baralho {
    String[] naipe = { "PAUS", "OUROS", "COPAS", "ESPADAS" };
    String[] numero = { "ÁS", "DOIS", "TRÊS", "QUATRO", "CINCO", "SEIS", "SETE", "OITO", "NOVE", "DEZ", "VALETE",
            "DAMA", "REI" };
    int quantidadeCartas;
    int quantidadeBaralho;
    int pontuacaoInicial = 0;
    int pontuacaoAtual = 0;
    pilhaEstatica deck;

    public baralho(int quantidadeBaralho) {
        if (quantidadeBaralho <= 0) {
            quantidadeBaralho = 1;
        }
        this.quantidadeCartas = quantidadeBaralho * 52;
        this.quantidadeBaralho = quantidadeBaralho;
        this.deck = new pilhaEstatica(this.quantidadeCartas);
    }

    public pilhaEstatica gerarCartas() {
        deck = new pilhaEstatica(quantidadeCartas);
        for (int i = 0; i < quantidadeBaralho; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 13; k++) {
                    this.deck.push(numero[k] + " de " + naipe[j]);
                    // System.out.println(deck.pop());

                }
            }
        }
        return deck;
    }

    public void embaralharDeck() {
        ArrayList<String> Deck = new ArrayList<String>();

        for (int i = 0; i < this.quantidadeCartas; i++) {
            Deck.add(deck.pop());
        }

        Collections.shuffle(Deck);

        for (String elemento : Deck) {
            this.deck.push(elemento);
        }
    }

    public String pegarCarta() {
        return this.deck.pop();
    }

    public int valorCarta(String carta) {
        int valor = 0;
        String auxiliar;

        System.out.println("Sua carta: " + carta);

        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 13; k++) {
                auxiliar = numero[k] + " de " + naipe[j];
                if (auxiliar.equals(carta)) {
                    switch (numero[k]) {
                        case "ÁS":
                            if (this.pontuacaoAtual == 20) {
                                valor = 1;
                            } if (this.pontuacaoAtual < 11){
                                valor = 11;
                            } else {
                                valor = 1;
                            }
                            break;
                        case "DOIS":
                            valor = 2;
                            break;
                        case "TRÊS":
                            valor = 3;
                            break;
                        case "QUATRO":
                            valor = 4;
                            break;
                        case "CINCO":
                            valor = 5;
                            break;
                        case "SEIS":
                            valor = 6;
                            break;
                        case "SETE":
                            valor = 7;
                            break;
                        case "OITO":
                            valor = 8;
                            break;
                        case "NOVE":
                            valor = 9;
                            break;
                        case "DEZ":
                            valor = 10;
                            break;
                        case "VALETE":
                            valor = 10;
                            break;
                        case "DAMA":
                            valor = 10;
                            break;
                        case "REI":
                            valor = 10;
                            break;
                        default:
                            break;
                    }
                }

            }
        }
        return valor;
    }

    public int pontos(String carta) {
        pontuacaoInicial = valorCarta(carta);
        pontuacaoAtual = pontuacaoAtual + pontuacaoInicial;
        return pontuacaoAtual;
    }

    public String validarGanhador(int jogador1, int jogador2 ){
        if (jogador1 == 21) {
            return "Parabéns, jogador 1 venceu!!";
        } if (jogador2 == 21) {
            return "Parabéns, jogador 2 venceu!!";
        } else {
            if (jogador1 == 21 && jogador2 == 21) {
                return "Parabéns, os dois venceram! Que tal jogarem mais uma partida?!";
            }
            if (jogador1 < jogador2) {
                return "Parabéns, jogador 1 venceu!!";
            } else {
                return "Parabéns, jogador 2 venceu!!";
            } 
        }
        

    }


}
