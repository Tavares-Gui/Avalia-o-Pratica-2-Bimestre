package Questao_2;

import java.util.HashMap;

public class AdapterTransacoes implements ProcessadorTransacoes {
    private SistemaBancarioLegado sistemaLegado;

    public AdapterTransacoes(SistemaBancarioLegado sistemaLegado) {
        this.sistemaLegado = sistemaLegado;
    }

    @Override
    public TransacaoResposta autorizar(String cartao, double valor, String moeda) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("numeroCartao", cartao);
        parametros.put("valorTransacao", valor);

        int codigoMoeda = converterMoedaParaCodigo(moeda);
        parametros.put("codigoMoeda", codigoMoeda);

        parametros.put("codigoBanco", "237");

        HashMap<String, Object> respostaLegado = sistemaLegado.processarTransacao(parametros);

        return new TransacaoResposta(
            (String) respostaLegado.get("status"),
            (String) respostaLegado.get("codigoAutorizacao"),
            (String) respostaLegado.get("mensagem")
        );
    }

    private int converterMoedaParaCodigo(String moeda) {
        if (moeda == null) {
            return 0;
        }

        switch (moeda.toUpperCase()) {
            case "USD":
                return 1;
            case "EUR":
                return 2;
            case "BRL":
                return 3;
            default:
                return 0;
    }
}
}
