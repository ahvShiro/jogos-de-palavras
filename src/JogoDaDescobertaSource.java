import java.util.Random;
import java.util.Scanner;

public class JogoDaDescobertaSource {    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Inicializa a array de palavrasPredefinidas()
        String[] arrayPalavras = palavrasPredefinidas();

        // Escolhe uma palavra da array
        String palavraEscolhida = arrayPalavras[random.nextInt(arrayPalavras.length)].toUpperCase();

        // Embaralha a palavra escolhida
        String palavraEmbaralhada = embaralharPalavraPorVetor(palavraEscolhida);

        // Gera a dica da palavra escolhida
        char[] dicaPalavra = mostrarDica(palavraEmbaralhada);

        System.out.printf("Palavra gerada: %s%nDigite \"!d\" para receber uma dica e \"!q\" para sair do programa%n", palavraEmbaralhada);

        int contadorTentativas = 0;

        while (true) {

            System.out.printf("Tenta adivinhar a palavra %s: ", palavraEmbaralhada);
            String inputUsuario = scanner.next().toUpperCase();


            // Checa input do usuário
            if (inputUsuario.equals("!D")) {
                System.out.printf("Dica: a primeira palavra é %s, e a última palavra é %s%n", dicaPalavra[0], dicaPalavra[1]);
                continue;
            }
            if (inputUsuario.equals("!Q")) {
                System.out.println("Programa finalizado por motivos de skill issue XD - Tentativas: " + contadorTentativas);
                break;
            }
            contadorTentativas++;

            if (inputUsuario.equals(palavraEscolhida)) {
                System.out.println("Parabéns, você acertou!!! - Tentativas: " + contadorTentativas);
                break;
            } else {
                System.out.println("Boa tentativa, mas não é essa palavra! - Tentativas: " + contadorTentativas);
            }
        }
    }

    private static String[] palavrasPredefinidas() {
        String[] palavras = {
                "cartola", "deslocamento", "material", "mascote",
                "calafrios", "poltrona", "material", "assobio",
                "diminuir", "multiplicação", "golfinho", "aumentar",
                "ferro", "especular", "lenha", "molho",
                "otorrinolaringologista", "electrofototermoterapeutico"
        };
        return palavras;
    }

    private static String embaralharPalavraPorVetor(String palavra) {
        Random random = new Random();
        char[] palavras = palavra.toCharArray();

        for (int i = 0; i < palavras.length; i++) {
            int iAleatorio = random.nextInt(palavras.length);

            char tmp = palavras[i];
            palavras[i] = palavras[iAleatorio];
            palavras[iAleatorio] = tmp;

        }
        return new String(palavras);
    }

    private static String embaralharPalavrasPorConcatenacao(String palavra) {
        String stringEmbaralhada = "";
        Random random = new Random();
        int tamanho = palavra.length();

        for (int i = 0; i < palavra.length(); i++) {
            stringEmbaralhada += palavra.charAt(random.nextInt(tamanho));
        }

        return stringEmbaralhada;
    }

    private static char[] mostrarDica(String palavra) {
        char[] dica = new char[2];

        dica[0] = palavra.charAt(0);
        dica[1] = palavra.charAt(palavra.length() - 1);

        return dica;
    }

}
