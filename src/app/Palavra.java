package app;

import java.util.Random;

public class Palavra {

    // perguntar pro professor como deixar essa codebase inteira escalável
    String[] palavrasPreSelecionadas = {
            "objeto", "classe", "método", "código", "vetor",
            "função", "pacote", "lógica", "buffer", "script",
            "sistema", "dados", "tela", "driver", "plugin",
            "thread", "kernel", "debug", "comando", "socket"
    };


    String embaralharPalavra(String palavra) {
        char[] letras = palavra.toCharArray();
        Random random = new Random();

        for (int i = letras.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }

        return new String(letras);
    }

    String palavraAleatoria(String[] arrayPalavras) {
        Random random = new Random();
        if (arrayPalavras == null) {
            return palavrasPreSelecionadas[random.nextInt(palavrasPreSelecionadas.length)];
        } else {
            return arrayPalavras[new Random().nextInt(arrayPalavras.length)];
        }
    }

    String[] gerarPalavrasAleatorias(String[] palavras, Integer tamanho) {
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

    char getPrimeiraLetra(String palavra) {
        return palavra.charAt(0);
    }

    char getUltimaLetra(String palavra) {
        return palavra.charAt(palavra.length() - 1);
    }

    char retornarLetrasPorIndice(String palavra, int indice) {
        return palavra.charAt(indice);
    }
}
