package app;


// alterar nome da classe, Mensagens/Saida

public class Saida {
    Palavra palavra = new Palavra();

    void listarItens(String[] itens) {
        for (int i = 0; i < itens.length; i++) {
            System.out.printf("%d. %scanner%n", (i + 1), itens[i]);
        }
    }

    void menuListado(String[] itens) {
        tituloCentralizado("Jogos de Palavras");
        listarItens(itens);
        tituloCentralizado("Escolha o jogo que você quer jogar");
        System.out.print("(1 ou 2): ");
    }


    void promptJogo(int contadorTentativas, String palavraEmbaralhada) {
        System.out.printf("Tentativas: %scanner%n", contadorTentativas);
        if (palavraEmbaralhada == null) {
            System.out.printf("Tenta adivinhar a palavra: %n");
        } else {
            System.out.printf("Tenta adivinhar a palavra %scanner: %n", palavraEmbaralhada);
        }
    }

    void imprimirDica(int contadorDicas, String palavraEscolhida) {
        char dicaPrimeiraLetra = palavra.pegarPrimeiraLetra(palavraEscolhida);
        char dicaUltimaLetra = palavra.pegarUltimaLetra(palavraEscolhida);

        if (contadorDicas == 0) {
            System.out.printf("[!] Dica: a primeira palavra é \"%scanner\", e a última palavra é \"%scanner\"%n", dicaPrimeiraLetra, dicaUltimaLetra);
        } else if (contadorDicas > 0 && contadorDicas < (palavraEscolhida.length() - 1)) {
            char letraUnicaDica = palavra.pegarLetrasPorIndice(palavraEscolhida, contadorDicas);
            System.out.printf("[!] Dica: a %sª letra da palavra é \"%scanner\"%n", (contadorDicas + 1), letraUnicaDica);
        } else {
            System.out.println("[!] Dica: parça já te dei a palavra inteira só coloca na resposta aí");
        }
    }

// descobri que em java, strings são imutáveis e cada vez que há concatenação
// em loop, cada iteração cria um objeto novo na memória(!)

    void tituloCentralizado(String titulo) {
        int quantidadePadding = (50 - titulo.length() - 2) / 2;
        char[] linha = new char[50];

        // ==================================================
        for (int i = 0; i < linha.length; i++) {
            linha[i] = '=';
        }

        // =============== ==================================
        linha[quantidadePadding] = ' ';

        // =============== Jogos de Palavras=================
        for (int j = 0; j < titulo.length(); j++) {
            linha[quantidadePadding + 1 + j] = titulo.charAt(j);
        }

        // =============== Jogos de Palavras ================
        linha[quantidadePadding + 1 + titulo.length()] = ' ';

        System.out.println(new String(linha));
    }

    void imprimirTentativas(int contador) {
        System.out.println("Tentativas: " + contador);
    }

    public void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
