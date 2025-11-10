package Questao_2;

import java.util.HashMap;

public class SistemaBancarioLegado {
    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        HashMap<String, Object> resposta = new HashMap<>();

        if (!parametros.containsKey("cartao") || !parametros.containsKey("valor") || !parametros.containsKey("codigoBanco")) {
            resposta.put("status", "ERRO");
            resposta.put("mensagem", "Campos obrigatórios ausentes no sistema legado!");
            return resposta;
        }

        double valor = (double) parametros.get("valor");
        if (valor <= 1000) {
            resposta.put("status", "Aprovado");
            resposta.put("codigoAutorizacao", "LEG-" + System.currentTimeMillis());
        } else {
            resposta.put("status", "Negado");
            resposta.put("motivo", "Limite excedido");
        }

        return resposta;
    }
}
