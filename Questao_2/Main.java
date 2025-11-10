package Questao_2;

public class Main {
    public static void main(String[] args) {
        SistemaBancarioLegado sistemaLegado = new SistemaBancarioLegado();
        AdapterTransacoes adapter = new AdapterTransacoes(sistemaLegado);

        System.out.println("Teste de Adapter bidirecional ");
        TransacaoResposta resposta1 = adapter.autorizar("1234-5678-9876-5432", 1500.75, "BRL");
        System.out.println(resposta1);

        System.out.println("\nTeste com moeda diferente ");
        TransacaoResposta resposta2 = adapter.autorizar("9999-8888-7777-6666", 500.50, "USD");
        System.out.println(resposta2);

        System.out.println("\nTeste com moeda invalida ");
        TransacaoResposta resposta3 = adapter.autorizar("1111-2222-3333-4444", 100.00, "JPY");
        System.out.println(resposta3);
    }
}
