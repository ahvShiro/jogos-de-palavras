package view;

import model.Matriz;
import model.Palavra;

public class ViewElements {

    public void printMenu() {
        tituloCentralizado("Jogos de Palavras");
        System.out.println("1. Jogo da Descoberta");
        System.out.println("2. Caça Palavras (Uma palavra)");
        tituloCentralizado("Escolha o jogo que você quer jogar");
        System.out.print("(1 ou 2): ");
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void imprimirTentativa(int contadorTentativas) {
        System.out.println("Tentativas: " + contadorTentativas);
    }

    public static void imprimirDica(int contadorDicas, Palavra palavra) {

        int tam = palavra.getPalavra().length();

        if (contadorDicas == 0) {
            char dicaPrimeiraLetra = palavra.getPrimeiraLetra();
            char dicaUltimaLetra = palavra.getUltimaLetra();

            System.out.printf("[!] Dica: a primeira palavra é \"%c\", e a última palavra é \"%c\"%n", dicaPrimeiraLetra, dicaUltimaLetra);

        } else if (contadorDicas > 0 && contadorDicas < (tam - 1)) {

            char letra = palavra.pegarLetrasPorIndice(contadorDicas);
            System.out.printf("[!] Dica: a %sª letra da palavra é \"%s\"%n", (contadorDicas + 1), letra);

        } else {

            System.out.println("[!] Dica: parça já te dei a palavra inteira só coloca na resposta aí");

        }
    }

    public void imprimirTentativas(int contador) {
        System.out.println("Tentativas: " + contador);
    }

    public void imprimirMatriz(Matriz matriz) {
        char[][] mat = matriz.getMatriz();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void tituloCentralizado(String titulo) {
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
}
