package app;

import java.util.*;

public class Palavra {
    Random random = new Random();
    String[] palavrasPreSelecionadas = {
            "objeto", "classe", "método", "código", "vetor",
            "função", "pacote", "lógica", "buffer", "script",
            "sistema", "dados", "tela", "driver", "plugin",
            "thread", "kernel", "debug", "comando", "socket"
    };

    private String palavra = "";
    private String palavraEmbaralhada = "";

    public Palavra() {
        this.palavra = palavraAleatoria(this.palavrasPreSelecionadas);
        this.palavraEmbaralhada = embaralharPalavra(this.palavra);
    }

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.palavraEmbaralhada = embaralharPalavra(this.palavra);
    }

    public String getPalavra() {
        return palavra;
    }

    public String getPalavraEmbaralhada() {
        return palavraEmbaralhada;
    }

    String embaralharPalavra(String palavra) {
        char[] letras = palavra.toCharArray();

        for (int i = letras.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }
        return new String(letras);
    }

    String palavraAleatoria(String[] arrayPalavras) {
        if (arrayPalavras == null) {
            return palavrasPreSelecionadas[random.nextInt(palavrasPreSelecionadas.length)];
        } else {
            return arrayPalavras[new Random().nextInt(arrayPalavras.length)];
        }
    }

    char pegarPrimeiraLetra() {
        return this.palavra.charAt(0);
    }

    char pegarUltimaLetra() {
        return this.palavra.charAt(palavra.length() - 1);
    }

    char pegarLetrasPorIndice(int indice) {
        if (indice >= 0 && indice < this.palavra.length()) {
            return this.palavra.charAt(indice);
        }
        return ' ';
    }
}
