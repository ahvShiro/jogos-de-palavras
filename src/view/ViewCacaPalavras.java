package view;

import model.Matriz;
import java.util.Scanner;
import static view.ViewElements.*;
import controller.ControllerGame;
import model.Palavra;

public class ViewCacaPalavras {

    private ViewElements elements = new ViewElements();
    private ControllerGame controller = new ControllerGame();
    private Scanner scanner = new Scanner(System.in);
    private String answer;
    
    boolean pediuDica = false;

    public void promptCacaPalavras(Matriz matriz, Palavra palavra) {

        controller.gameStart(palavra);

        do {
            limparTela();
            elements.imprimirMatriz(matriz);
            System.out.println("Tente adivinhar a palavra: ");

            answer = scanner.nextLine();

            if (controller.checarPalavraCerta(answer)) {
                System.out.println("Parabéns, você acertou!!!");
                imprimirTentativa(controller.getContadorTentativas());
                break;

            } else if (controller.checarDesistencia(answer)) {
                System.out.println("Jogo encerrado. A palavra era " + palavra.getPalavra());
                imprimirTentativa(controller.getContadorTentativas());
                break;
            
            } else if (controller.checarDica(answer)) {
                imprimirDica(controller.getContadorDicas(), palavra);
                controller.incrementarDicas();
                pediuDica = false;
            }
            
            controller.incrementarTentativas();
        } while (!controller.checarDesistencia(answer) && !controller.checarPalavraCerta(answer)); // Repete enquanto o usuário não acertar ou desistir
    }
}
