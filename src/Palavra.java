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

    private String[] gerarPalavrasAleatorias (String[] palavras, Integer tamanho){
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

    public char getPrimeiraLetra(String palavra) {
        return palavra.charAt(0);
    }

    private char getUltimaLetra(String palavra) {
        return palavra.charAt(palavra.length() - 1);
    }
}
