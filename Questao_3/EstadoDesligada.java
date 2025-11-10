package Questao_3;

public class EstadoDesligada implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        if (usina.getTemperatura() > 0) {
            usina.setEstado(new EstadoOperacaoNormal());
        }
    }

    @Override
    public String getNome() {
        return "Desligada";
    }
}
