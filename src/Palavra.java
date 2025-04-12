import java.util.Random;

public class Palavra {

    String[] palavrasPreSelecionadas = {
            "cartola", "deslocamento", "material", "mascote",
            "calafrios", "poltrona", "material", "assobio",
            "diminuir", "multiplicação", "golfinho", "aumentar",
            "ferro", "especular", "lenha", "molho",
            "otorrinolaringologista", "electrofototermoterapeutico"
    };


    private String embaralharPalavra(String palavra) {
        String stringEmbaralhada = "";
        Random random = new Random();
        int tamanho = palavra.length();

        for (int i = 0; i < palavra.length(); i++) {
            stringEmbaralhada += palavra.charAt(random.nextInt(tamanho));
        }

        return stringEmbaralhada;
    }

    private String palavraAleatoria(String[] arrayPalavras) {
        return arrayPalavras[new Random().nextInt(arrayPalavras.length)];
    }

    public char getPrimeiraLetra(String palavra) {
        return palavra.charAt(0);
    }

    private char getUltimaLetra(String palavra) {
        return palavra.charAt(palavra.length() - 1);
    }
}
