package app;

import java.util.Random;

public class Matriz {

    char[][] gerarMatrizVazia(int tamanho) {
        return new char[tamanho][tamanho];
    }

    public void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    char[][] preencherMatriz(char[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (char) ('a' + new Random().nextInt(26));
            }
        }

        return matriz;
    }

    public char[][] inserirPalavraHorizontal(char[][] matriz, String palavra) {

        int linhaAleatoria = new Random().nextInt(matriz.length);
        int colunaAleatoria = new Random().nextInt(matriz.length - palavra.length() + 1);

        for (int i = 0; i < palavra.length(); i++) {
            matriz[linhaAleatoria][colunaAleatoria + i] = palavra.charAt(i);
        }

        return matriz;
    }

    public char[][] inserirPalavraVertical(char[][] matriz, String palavra) {

        int linhaAleatoria = new Random().nextInt(matriz.length - palavra.length() + 1);
        int colunaAleatoria = new Random().nextInt(matriz.length);

        for (int i = 0; i < palavra.length(); i++) {
            matriz[linhaAleatoria + i][colunaAleatoria] = palavra.charAt(i);
        }

        return matriz;
    }
}
