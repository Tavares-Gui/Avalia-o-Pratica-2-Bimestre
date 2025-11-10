package Questao_3;

public class Main {
    public static void main(String[] args) {
        UsinaNuclear usina = new UsinaNuclear();

        System.out.println("Estado inicial: " + usina.getEstadoAtual().getNome());

        usina.atualizarCondicoes(310, 50, 0.5, true, 0);  // Vai para Alerta Amarelo
        usina.atualizarCondicoes(420, 60, 0.5, true, 35); // Vai para Alerta Vermelho
        usina.atualizarCondicoes(420, 60, 0.5, false, 35); // Sistema falhou → Emergência

        usina.ativarManutencao();
        usina.atualizarCondicoes(500, 70, 1.0, false, 50); // Ignorado

        usina.ativarManutencao();
        System.out.println("Estado atual: " + usina.getEstadoAtual().getNome());
    }
}
