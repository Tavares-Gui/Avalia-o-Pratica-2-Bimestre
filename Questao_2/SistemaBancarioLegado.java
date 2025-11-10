package Questao_2;

import java.util.HashMap;

public class SistemaBancarioLegado {

    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        System.out.println("Legado - Processando transacao no sistema legado");

        if (!parametros.containsKey("codigoBanco")) {
            parametros.put("codigoBanco", "001");
        }

        HashMap<String, Object> resposta = new HashMap<>();
        resposta.put("status", "Aprovado");
        resposta.put("codigoAutorizacao", "XYZ123");
        resposta.put("mensagem", "Transacao aprovada pelo sistema legado.");

        return resposta;
    }
}
