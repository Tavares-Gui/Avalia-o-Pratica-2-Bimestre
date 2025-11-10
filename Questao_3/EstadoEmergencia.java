package Questao_3;

public class EstadoEmergencia implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        System.out.println("Emergência ativada - Procedimentos de desligamento acionados.");
    }

    @Override
    public String getNome() {
        return "Emergencia";
    }
}
