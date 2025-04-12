import java.util.Scanner;
import java.util.Random;

public class CacaPalavrasSource {
    private static final String[] palavras = {"agua", "camelo", "triste", "cambio", "sapos"};

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int tamanho = 10;

        char[][] tabuleiroVazio = gerarMatrizVazia(tamanho);

        char[][] tabuleiroCheio = encherMatriz(tabuleiroVazio);

        String palavrasAleatorias = palavras[random.nextInt(0, palavras.length)].toUpperCase();

        System.out.println(String.join(",", palavrasAleatorias));

        imprimirMatriz(inserirPalavraVertical(tabuleiroCheio, palavrasAleatorias));

        char[] dicaPalavra = mostrarDica(palavrasAleatorias);

        System.out.printf("Digite \"!d\" para receber uma dica e \"!q\" para sair do programa%n");

        int contadorTentativas = 0;

        while (true) {

            System.out.println("Tenta adivinhar a palavra: ");
            String inputUsuario = scanner.next().toUpperCase();


            // Checa input do usuário
            if (inputUsuario.equals("!D")) {
                System.out.printf("Dica: a primeira palavra é %s, e a última palavra é %s%n", dicaPalavra, dicaPalavra[1]);
                continue;
            }
            if (inputUsuario.equals("!Q")) {
                System.out.println("Programa finalizado por motivos de skill issue XD - Tentativas: " + contadorTentativas);
                break;
            }
            contadorTentativas++;

            if (inputUsuario.equals(palavrasAleatorias)) {
                System.out.println("Parabéns, você acertou!!! - Tentativas: " + contadorTentativas);
                break;
            }
            else {
                System.out.println("Boa tentativa, mas não é essa palavra! - Tentativas: " + contadorTentativas);
            }
        }

    }

    private static char[][] gerarMatrizVazia(int tamanho) {
        return new char[tamanho][tamanho];
    }

    private static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] encherMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (char) ('a' + new Random().nextInt(26));
            }
        }
        return matriz;
    }

    public static char[][] inserirPalavraHorizontal(char[][] matriz, String palavra) {

        int linhaAleatoria = new Random().nextInt(matriz.length);
        int colunaAleatoria = new Random().nextInt(matriz.length - palavra.length() + 1);

        for (int i = 0; i < palavra.length(); i++) {
            matriz[linhaAleatoria][colunaAleatoria + i] = palavra.charAt(i);
        }

        return matriz;
    }

    public static char[][] inserirPalavraVertical(char[][] matriz, String palavra) {

        int linhaAleatoria = new Random().nextInt(matriz.length - palavra.length() + 1);
        int colunaAleatoria = new Random().nextInt(matriz.length);

        for (int i = 0; i < palavra.length(); i++) {
            matriz[linhaAleatoria + i][colunaAleatoria] = palavra.charAt(i);
        }

        return matriz;
    }
        private static char[] mostrarDica(String palavra) {
        char[] dica = new char[2];

        dica[0] = palavra.charAt(0);
        dica[1] = palavra.charAt(palavra.length() - 1);

        return dica;
    }
}