package app;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        Saida saida = new Saida();
        Scanner scanner = new Scanner(System.in);

        String[] opcoes = {"Jogo da Descoberta", "Caça-Palavras"};

        saida.menuListado(opcoes);

        while (true) {
            int input = scanner.nextInt();
            if (input == 1) {
                jogo.comecarJogoDaDescoberta();
                break;
            }
            if (input == 2) {
                // jogo básico, com apenas uma palavra
                jogo.comecarCacaPalavras();
                break;
            } else {
                System.out.println("Digite uma opção válida");
            }
        }
    }
}
