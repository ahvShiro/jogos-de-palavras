package app;

import java.util.*;

public class Jogo {
    Palavra p = new Palavra();
    Matriz m = new Matriz();
    Scanner s = new Scanner(System.in);
    IO io = new IO();

    // colocar um c0onstrutor aqui?
    String palavraEscolhida = p.palavraAleatoria(null);
    int contadorTentativas = 0;
    int contadorDicas = 0;
    int tamanhoMatriz = 0;

    private boolean checarDica(String inputUsuario) {
        return inputUsuario.equals("!D") || inputUsuario.equals("!d");
    }

    private boolean checarDesistencia(String inputUsuario) {
        return inputUsuario.equals("!Q") || inputUsuario.equals("!q");
    }

    private boolean checarPalavraCerta(String inputUsuario) {
        if (inputUsuario.equals(palavraEscolhida)) {
            return true;
        } else {
            return false;
        }
    }

    public void comecarCacaPalavras() {
        io.tituloCentralizado("CAÇA PALAVRAS");
        tamanhoMatriz = 10;
        char[][] tabuleiroVazio = m.gerarMatrizVazia(tamanhoMatriz);

        char[][] tabuleiro = m.preencherMatriz(tabuleiroVazio);

        if (new Random().nextInt(1, 3) == 1) {
            m.inserirPalavraVertical(tabuleiro, palavraEscolhida);
        } else {
            m.inserirPalavraHorizontal(tabuleiro, palavraEscolhida);
        }

        m.imprimirMatriz(tabuleiro);

        // repetição de código não é legal, mas não sei como fazer de outro jeito por causa desse while true
        while (true) {
            io.promptJogo(contadorTentativas, null);

            String inputUsuario = s.next();

            if (checarDica(inputUsuario)) {
                io.imprimirDica(contadorTentativas, palavraEscolhida);
                contadorDicas++;
                continue;
            } else if (checarDesistencia(inputUsuario)) {
                System.out.println("Programa finalizado por motivos de skill issue XD");
                io.imprimirTentativas(contadorTentativas);
                break;
            }

            contadorTentativas++;
            if(checarPalavraCerta(inputUsuario)) {
                System.out.println("Parabéns, você acertou!!!");
                io.imprimirTentativas(contadorTentativas);
                break;
            } else {
                System.out.println("Boa tentativa, mas não é essa palavra!");
                io.imprimirTentativas(contadorTentativas);
                
            }
        }
    }

    public void comecarJogoDaDescoberta() {
        io.tituloCentralizado("JOGO DA DESCOBERTA");

        String palavraEmbaralhada = p.embaralharPalavra(palavraEscolhida);

        // repetição de código não é legal, mas não sei como fazer de outro jeito por causa desse while true
        while (true) {
            io.promptJogo(contadorTentativas, palavraEmbaralhada);

            String inputUsuario = s.next();

            if (checarDica(inputUsuario)) {
                io.imprimirDica(contadorTentativas, palavraEscolhida);
                contadorDicas++;
                continue;
            } else if (checarDesistencia(inputUsuario)) {
                System.out.println("Programa finalizado por motivos de skill issue XD");
                break;
            }

            contadorTentativas++;
            if(checarPalavraCerta(inputUsuario)) {
                System.out.println("Parabéns, você acertou!!!");
                io.imprimirTentativas(contadorTentativas);
                break;
            } else {
                System.out.println("Boa tentativa, mas não é essa palavra!");
                io.imprimirTentativas(contadorTentativas);
            }
        }
    }


}

