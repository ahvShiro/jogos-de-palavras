import view.ViewElements;
import view.ViewJogoDaDescoberta;
import view.ViewCacaPalavras;

import model.Palavra;
import model.Matriz;

import java.util.Scanner;
import static view.ViewElements.limparTela;

public class Main {
    public static void main(String[] args) {
        ViewElements element = new ViewElements();
        Scanner scanner = new Scanner(System.in);

        element.printMenu();
        int escolha = scanner.nextInt();

        limparTela();

        Palavra palavra = new Palavra();
        
        switch(escolha) {
            case 1:
                // Jogo da Descoberta
                ViewJogoDaDescoberta viewJogoDaDescoberta = new ViewJogoDaDescoberta();
                viewJogoDaDescoberta.promptJogoDaDescoberta(palavra);
                break;
            case 2:
                // Caça Palavras
                Matriz matriz = new Matriz(10);

                // Inserir palavra horizontalmente ou verticalmente
                if (Math.random() < 0.5) {
                    matriz.inserirPalavraVertical(palavra.getPalavra());
                } else {
                    matriz.inserirPalavraHorizontal(palavra.getPalavra());
                }
                
                ViewCacaPalavras viewCacaPalavras = new ViewCacaPalavras();
                viewCacaPalavras.promptCacaPalavras(matriz, palavra);
                break;
            default:
                System.out.println("Opção inválida.");

        }
    }
}