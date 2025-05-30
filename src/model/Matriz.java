package model;
import java.util.Random;

public class Matriz {
    Random random = new Random();
    private char[][] matriz;
    private int tamanho = 10;

    public Matriz(int tamanho) {
        this.tamanho = tamanho;
        this.matriz = gerarMatrizPreenchida();
    }

    char[][] gerarMatrizPreenchida() {
        char[][] matrizNova = new char[tamanho][tamanho];
        for (int i = 0; i < matrizNova.length; i++) {
            for (int j = 0; j < matrizNova.length; j++) {
                matrizNova[i][j] = (char) ('a' + random.nextInt(26));
            }
        }
        return matrizNova;
    }

    public boolean inserirPalavraHorizontal(String palavra) {
        int linha = random.nextInt(matriz.length);
        int colunaMaxima = tamanho - palavra.length();
        if (colunaMaxima < 0) {
            return false;
        }
        int coluna = random.nextInt(colunaMaxima + 1);

        for (int i = 0; i < palavra.length(); i++) {
            matriz[linha][coluna + i] = palavra.charAt(i);
        }

        return true;
    }

    public boolean inserirPalavraVertical(String palavra) {
        int coluna = random.nextInt(matriz.length);
        int linhaMaxima = matriz.length - palavra.length();
        if (linhaMaxima < 0) {
            return false;
        }

        int linha = random.nextInt(linhaMaxima + 1);

        for (int i = 0; i < palavra.length(); i++) {
            matriz[linha + i][coluna] = palavra.charAt(i);
        }
        return true;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public int getTamanho() {
        return tamanho;
    }
}
