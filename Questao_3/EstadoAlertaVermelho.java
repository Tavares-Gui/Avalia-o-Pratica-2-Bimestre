package Questao_3;

public class EstadoAlertaVermelho implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        if (!usina.isSistemaResfriamentoAtivo()) {
            usina.setEstado(new EstadoEmergencia());
        } else if (usina.getTemperatura() < 350) {
            usina.setEstado(new EstadoAlertaAmarelo());
        }
    }

    @Override
    public String getNome() {
        return "Alerta_vermelho";
    }
}
