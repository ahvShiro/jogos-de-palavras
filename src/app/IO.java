package app;


public class IO {
    Palavra palavra = new Palavra();

    void listarItens(String[] itens) {
        for (int i = 0; i < itens.length; i++) {
            System.out.printf("%d. %s%n", (i + 1), itens[i]);
        }
    }

    void menuListado(String[] itens) {
        tituloCentralizado("Jogos de Palavras");
        listarItens(itens);
        tituloCentralizado("Escolha o jogo que você quer jogar");
        System.out.println("(1 ou 2): ");
    }


    void promptJogo(int contadorTentativas, String palavraEmbaralhada) {
        System.out.printf("Tentativas: %s%n", contadorTentativas);
        if (palavraEmbaralhada == null) {
            System.out.printf("Tenta adivinhar a palavra: %n");
        } else {
            System.out.printf("Tenta adivinhar a palavra %s: %n", palavraEmbaralhada);
        }
    }

    void imprimirDica(int contadorDicas, String palavraEscolhida) {
        char dicaPrimeiraLetra = palavra.getPrimeiraLetra(palavraEscolhida);
        char dicaUltimaLetra = palavra.getUltimaLetra(palavraEscolhida);

        if (contadorDicas == 0) {
            System.out.printf("[!] Dica: a primeira palavra é \"%s\", e a última palavra é \"%s\"%n", dicaPrimeiraLetra, dicaUltimaLetra);
        } else if (contadorDicas > 0 && contadorDicas < (palavraEscolhida.length() - 1)) {
            char letraUnicaDica = palavra.retornarLetrasPorIndice(palavraEscolhida, contadorDicas);
            System.out.printf("[!] Dica: a %sª letra da palavra é \"%s\"%n", (contadorDicas + 1), letraUnicaDica);
        } else {
            System.out.println("[!] Dica: parça já te dei a palavra inteira só coloca na resposta aí");
        }
    }

//    // descobri que em java, strings são imutáveis e cada vez que eu concateno, eu crio um objeto novo na memória
//    void tituloCentralizado(String titulo) {
//
//        int quantidadePadding = (50 - titulo.length() - 2) / 2;
//        String tituloCentralizado = "";
//
//
//        for (int i = 0; i < quantidadePadding; i++) {
//            tituloCentralizado = tituloCentralizado + "=";
//        }
//
//        tituloCentralizado = tituloCentralizado + " " + titulo + " ";
//        if (titulo.length() % 2 == 0) {
//            for (int i = 0; i < quantidadePadding - 1; i++) {
//                tituloCentralizado = tituloCentralizado + "=";
//            }
//        } else {
//            for (int i = 0; i < quantidadePadding; i++) {
//                tituloCentralizado = tituloCentralizado + "=";
//            }
//        }
//
//        System.out.println(tituloCentralizado);
//    } ==================== Exemplos ====================

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
}
