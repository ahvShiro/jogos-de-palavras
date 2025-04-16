package app;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        IO io = new IO();
        Scanner scanner = new Scanner(System.in);

        String[] opcoes = {"Jogo da Descoberta", "Caça-Palavras"};

        io.menuListado(opcoes);

        while (true) {
            int input = scanner.nextInt();
            if (input == 1) {
                jogo.comecarJogoDaDescoberta();
                break;
            }
            if (input == 2) {
                jogo.comecarCacaPalavras();
                break;
            } else {
                System.out.println("Digite uma opção válida");
            }
        }
    }
}
