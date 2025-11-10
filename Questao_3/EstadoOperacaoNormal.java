package Questao_3;

public class EstadoOperacaoNormal implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        if (usina.getTemperatura() > 300) {
            usina.setEstado(new EstadoAlertaAmarelo());
        }
    }

    @Override
    public String getNome() {
        return "Operacao_normal";
    }
}
