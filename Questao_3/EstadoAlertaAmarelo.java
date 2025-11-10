package Questao_3;

public class EstadoAlertaAmarelo implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        if (usina.getTemperatura() > 400 && usina.getTempoTemperaturaAlta() > 30) {
            usina.setEstado(new EstadoAlertaVermelho());
        } else if (usina.getTemperatura() < 280) {
            usina.setEstado(new EstadoOperacaoNormal());
        }
    }

    @Override
    public String getNome() {
        return "Alerta_amarelo";
    }
}
