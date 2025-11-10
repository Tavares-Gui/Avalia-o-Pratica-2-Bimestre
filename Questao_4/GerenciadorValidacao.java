package Questao_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GerenciadorValidacao {

    private List<Validador> cadeia = new ArrayList<>();
    private int maxFalhasParaCircuitBreaker = 3;
    private int contadorFalhas = 0;

    private static final Stack<Runnable> pilhaRollbacks = new Stack<>();

    public static void registrarRollback(Runnable acao) {
        pilhaRollbacks.push(acao);
    }

    public void adicionarValidador(Validador validador) {
        cadeia.add(validador);
    }

    public ResultadoValidacao executar(DocumentoNF doc) {
        contadorFalhas = 0;
        boolean algumAnteriorFalhou = false;

        for (int i = 0; i < cadeia.size(); i++) {
            Validador val = cadeia.get(i);

            if (contadorFalhas >= maxFalhasParaCircuitBreaker) {
                System.out.println("Circuit_breaker - Numero maximo de falhas atingido. Interrompendo cadeia.");
                executarRollback();
                return ResultadoValidacao.falha("Circuit breaker - interrompido apos " + contadorFalhas + " falhas");
            }

            if (val.exigeAnteriorOk() && algumAnteriorFalhou) {
                System.out.println("Pulando " + val.nome() + " pois um validador anterior falhou.");
                continue;
            }

            System.out.println("Executando validador: " + val.nome());
            ResultadoValidacao res;
            try {
                res = val.validar(doc);
            } catch (Exception e) {
                res = ResultadoValidacao.falha("Excecao: " + e.getMessage());
            }

            if (!res.isOk()) {
                contadorFalhas++;
                algumAnteriorFalhou = true;
                System.out.println("Validacao falhou em " + val.nome() + " -> " + res.getMensagem());

                if (val instanceof ValidadorSchemaXML) {
                    System.out.println("Politica: Schema falhou — pulando validacao SEFAZ.");
                }

                if (contadorFalhas >= maxFalhasParaCircuitBreaker) {
                    System.out.println("Circuit breaker - Ate aqui houve " + contadorFalhas + " falhas. Executando rollback.");
                    executarRollback();
                    return ResultadoValidacao.falha("Falha critica: rollbacks executados");
                }
            } else {
                System.out.println(val.nome() + " passou.");
            }
        }

        if (contadorFalhas > 0) {
            System.out.println("Houve " + contadorFalhas + " falhas. Executando rollback das acoes registradas.");
            executarRollback();
            return ResultadoValidacao.falha("Validacoes completadas com falhas: " + contadorFalhas);
        }

        return ResultadoValidacao.ok();
    }

    private void executarRollback() {
        while (!pilhaRollbacks.isEmpty()) {
            try {
                Runnable acao = pilhaRollbacks.pop();
                acao.run();
            } catch (Exception e) {
                System.out.println("Rollback - Erro durante rollback: " + e.getMessage());
            }
        }
    }
}
