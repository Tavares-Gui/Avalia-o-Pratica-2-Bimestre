package Questao_2;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        SistemaBancarioLegado legado = new SistemaBancarioLegado();
        ProcessadorTransacoes adaptador = new AdapterTransacoes(legado);

        System.out.println("Teste 1: Transacao aprovada");
        TransacaoResposta resposta1 = adaptador.autorizar("1234-5678-9999-0000", 500.0, "BRL");
        System.out.println(resposta1);

        System.out.println("\nTeste 2: Transacao negada");
        TransacaoResposta resposta2 = adaptador.autorizar("1234-5678-9999-0000", 1500.0, "BRL");
        System.out.println(resposta2);

        System.out.println("\nTeste 3: Falta de campo obrigatorio");
        SistemaBancarioLegado legadoErro = new SistemaBancarioLegado() {
            @Override
            public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
                parametros.remove("codigoBanco");
                return super.processarTransacao(parametros);
            }
        };
        ProcessadorTransacoes adaptadorErro = new AdapterTransacoes(legadoErro);
        TransacaoResposta resposta3 = adaptadorErro.autorizar("9876-5432-1111-2222", 800.0, "USD");
        System.out.println(resposta3);
    }
}
