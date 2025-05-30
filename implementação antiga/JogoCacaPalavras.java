package model;

public class JogoCacaPalavras {

    public void comecarCacaPalavras() {
        saida.tituloCentralizado("CAÇA PALAVRAS");
        tamanhoMatriz = 10;

        // mudar matriz
        // abstrair isso em um construtor


        if (new Random().nextInt(1, 3) == 1) {
            matriz.inserirPalavraVertical(tabuleiro, palavraEscolhida);
        } else {
            matriz.inserirPalavraHorizontal(tabuleiro, palavraEscolhida);
        }

        matriz.imprimirMatriz(tabuleiro);

        // repetição de código não é legal, mas não sei como fazer de outro jeito por causa desse while true
        while (true) {
            saida.promptJogo(contadorTentativas, null);

            String inputUsuario = scanner.next();

            if (checarDica(inputUsuario)) {
                saida.imprimirDica(contadorTentativas, palavraEscolhida);
                contadorDicas++;
                continue;
            } else if (checarDesistencia(inputUsuario)) {
                System.out.println("Programa finalizado por motivos de skill issue XD");
                saida.imprimirTentativas(contadorTentativas);
                break;
            }

            contadorTentativas++;
            if(checarPalavraCerta(inputUsuario)) {
                System.out.println("Parabéns, você acertou!!!");
                saida.imprimirTentativas(contadorTentativas);
                break;
            } else {
                System.out.println("Boa tentativa, mas não é essa palavra!");
                saida.imprimirTentativas(contadorTentativas);
            }
        }
    }
}
