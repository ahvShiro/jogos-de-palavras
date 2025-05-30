package controller;

import model.Palavra;

public class ControllerGame {
    private Integer contadorTentativas; 
    private Integer contadorDicas;
    private Boolean jogoAtivo;
    private Palavra palavra;

    // Construtor, inicializa o jogo
    public ControllerGame() {
        this.contadorTentativas = 0;
        this.contadorDicas = 0;
        this.jogoAtivo = false;
    }

    public void gameStart(Palavra palavra) {
        this.palavra = palavra;
        this.contadorTentativas = 0;
        this.contadorDicas = 0;
        this.jogoAtivo = true;
    }

     public boolean checarDica(String inputUsuario) {
         return inputUsuario.equalsIgnoreCase("!D");
     }

     public boolean checarDesistencia(String inputUsuario) {
         return inputUsuario.equalsIgnoreCase("!Q");
     }

     public void incrementarTentativas() {
        contadorTentativas++;
     }

     public void incrementarDicas() {
        contadorDicas++;
     }

     public boolean checarPalavraCerta(String inputUsuario) {
         return (inputUsuario.equalsIgnoreCase(palavra.getPalavra())) ? true : false;
     }

     // GETTERS AND SETTERS

     public boolean getGameStatus() {
        return jogoAtivo;
     }

     public void setGameStatus(boolean gameStatus) {
        this.jogoAtivo = gameStatus;
     }

     public Integer getContadorTentativas() {
        return contadorTentativas;
     }

     public Integer getContadorDicas() {
        return contadorDicas;
     }

}
