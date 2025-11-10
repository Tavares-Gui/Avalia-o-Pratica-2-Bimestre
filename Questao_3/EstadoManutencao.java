package Questao_3;

public class EstadoManutencao implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        System.out.println("Manutencao - Transicoes desativadas temporariamente.");
    }

    @Override
    public String getNome() {
        return "Manutencao";
    }
}
