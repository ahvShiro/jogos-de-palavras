package app;

    void promptJogo(int contadorTentativas, String palavraEmbaralhada) {
        System.out.printf("Tentativas: %d%n", contadorTentativas);
        if (palavraEmbaralhada == null) {
            System.out.print("Tenta adivinhar a palavra: ");
        } else {
            System.out.print("Tenta adivinhar a palavra %s: ", palavraEmbaralhada);
        }
    }

}
