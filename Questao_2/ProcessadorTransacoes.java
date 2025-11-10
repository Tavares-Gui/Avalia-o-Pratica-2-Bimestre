package Questao_2;

public interface ProcessadorTransacoes {
    /**
     * @param cartao
     * @param valor
     * @param moeda
     * @return
     */
    TransacaoResposta autorizar(String cartao, double valor, String moeda);
}
