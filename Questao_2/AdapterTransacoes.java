package Questao_2;

import java.util.HashMap;

public class AdapterTransacoes implements ProcessadorTransacoes {

    private final SistemaBancarioLegado sistemaLegado;

    public AdapterTransacoes(SistemaBancarioLegado sistemaLegado) {
        this.sistemaLegado = sistemaLegado;
    }

    @Override
    public TransacaoResposta autorizar(String cartao, double valor, String moeda) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("cartao", cartao);
        parametros.put("valor", valor);
        parametros.put("moeda", moeda);

        parametros.put("codigoBanco", "001");

        HashMap<String, Object> respostaLegado = sistemaLegado.processarTransacao(parametros);

        return converterRespostaLegado(respostaLegado);
    }

    private TransacaoResposta converterRespostaLegado(HashMap<String, Object> respostaLegado) {
        String status = (String) respostaLegado.getOrDefault("status", "DESCONHECIDO");
        String codigoAutorizacao = (String) respostaLegado.getOrDefault("codigoAutorizacao", null);
        String mensagem = (String) respostaLegado.getOrDefault("mensagem", "Sem mensagem");
        String motivo = (String) respostaLegado.getOrDefault("motivo", null);

        return new TransacaoResposta(status, codigoAutorizacao, mensagem, motivo);
    }
}
