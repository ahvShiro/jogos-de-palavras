package view;

import model.Palavra;
import java.util.Scanner;
import static view.ViewElements.*;
import controller.ControllerGame;


public class ViewJogoDaDescoberta {

    private Scanner scanner = new Scanner(System.in);
    private ControllerGame controller = new ControllerGame();
    private String answer;

    boolean pediuDica = false;

    public void promptJogoDaDescoberta(Palavra palavra) {

        controller.gameStart(palavra);

        do {
            limparTela();
            System.out.println(palavra.getPalavraEmbaralhada());
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
