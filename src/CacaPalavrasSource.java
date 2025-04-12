import java.util.Scanner;
import java.util.Random;

public class CacaPalavrasSource {
    private static final String[] palavras = {"agua", "camelo", "triste", "cambio", "sapos"};

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

//        Múltiplas palavras escondidas: Esconder várias palavras no tabuleiro em vez de apenas uma, e permitir que o jogador encontre todas para vencer.
//        Dificuldade ajustável: Permitir que o usuário escolha o nível de dificuldade, variando o tamanho do tabuleiro e o número de palavras escondidas.
//        Pontuação: Criar um sistema de pontos baseado no tempo gasto e na quantidade de dicas usadas.
//        Modo infinito: Gerar novos tabuleiros automaticamente após cada vitória, permitindo que o jogador continue jogando indefinidamente.
//        Listagem de palavras encontradas: Criar um placar que exibe todas as palavras encontradas pelo usuário até o momento;
//        Dicas progressivas: Permitir que o jogador peça mais dicas, como revelar uma letra adicional da palavra escondida
//        Posicionamento variável: Fazer com que as palavras possam ser escondidas não apenas na horizontal e vertical, mas também na diagonal.


        int tamanho = 10;

        char[][] tabuleiroVazio = gerarMatrizVazia(tamanho);

        char[][] tabuleiroCheio = encherMatriz(tabuleiroVazio);
        // lógica para gerar uma única palavra
        String palavrasAleatorias = palavras[random.nextInt(0, palavras.length)].toUpperCase();

        // Comente o trecho para múltiplas palavras:
        // String[] palavrasAleatorias = gerarPalavrasAleatorias(palavras, 3);

        // Comente a impressão que espera um array:
        // System.out.println(String.join(",", palavrasAleatorias));
        System.out.println(palavrasAleatorias);

        imprimirMatriz(inserirPalavraVertical(tabuleiroCheio, palavrasAleatorias));

        char[] dicaPalavra = mostrarDica(palavrasAleatorias);

        System.out.printf("Digite \"!d\" para receber uma dica e \"!q\" para sair do programa%n");

        int contadorTentativas = 0;
        // Comente a verificação de acertos múltiplos:
        // boolean[] palavraAcertada = new boolean[palavrasAleatorias.length];
        // for (int i = 0; i < palavrasAleatorias.length; i++) {
        //     // ...
        // }

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
            // como garantir que não haverá repetições de checagens? exemplo checar agua duas vezes e dar como certo duas vezes
//            for (int i = 0; i < palavrasAleatorias.length; i++) {
//                if (inputUsuario.equals(palavrasAleatorias[i])) {
//                    if (!palavraAcertada[i]) {
//                        palavraAcertada[i] = true;
//                        System.out.printf("Parabéns, você acertou a palavra %s", palavrasAleatorias[i]);
//                    } else {
//                        System.out.printf("Você já acertou a palavra %s", palavrasAleatorias[i]);
//                    }
//                } else{
//                        System.out.println("Boa tentativa, mas não é essa palavra! - Tentativas: " + contadorTentativas);
//                    }
//                }
//
//            }


            // Lógica para uma palavra só
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
                } else {
                    System.out.println("Boa tentativa, mas não é essa palavra! - Tentativas: " + contadorTentativas);
                }
            }
        }


    }

    private static String[] gerarPalavrasAleatorias(String[] palavras, Integer tamanho) {
        Random random = new Random();
        if (tamanho == null) {
            tamanho = palavras.length;
        }

        // Embaralhamento Fisher-Yates
        String[] clonePalavras = palavras.clone();

        for (int i = 0; i < palavras.length; i++) {
            int j = random.nextInt(0, clonePalavras.length - 1);

            String tmp = clonePalavras[i];
            clonePalavras[i] = clonePalavras[j];
            clonePalavras[j] = tmp;
        }

        String[] palavrasGeradas = new String[tamanho];

        System.arraycopy(clonePalavras, 0, palavrasGeradas, 0, tamanho);

        return palavrasGeradas;
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