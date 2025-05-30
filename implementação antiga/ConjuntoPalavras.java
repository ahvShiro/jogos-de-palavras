package model;

import java.util.Random;

public class ConjuntoPalavras {

    private int quantidade = 2;
    private String[] conjunto;
    private boolean[] palavraFoiEncontrada;
    private String[] palavrasPreSelecionadas = {
            "objeto", "classe", "método", "código", "vetor",
            "função", "pacote", "lógica", "buffer", "script",
            "sistema", "dados", "tela", "driver", "plugin",
            "thread", "kernel", "debug", "comando", "socket"
    };

    public ConjuntoPalavras() {}

    public ConjuntoPalavras(int quantidade, String[] conjuntoDePalavras) {
        this.quantidade = quantidade;
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
}
