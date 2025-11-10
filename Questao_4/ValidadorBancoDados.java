package Questao_4;

import java.util.concurrent.atomic.AtomicBoolean;

public class ValidadorBancoDados extends ValidadorAbstrato {
    private AtomicBoolean inserido = new AtomicBoolean(false);

    @Override
    protected ResultadoValidacao executarValidacao(DocumentoNF doc) throws Exception {
        String numero = doc.getNumero();
        if ("Duplicado".equals(numero)) {
            return ResultadoValidacao.falha("Documento duplicado no banco");
        }

        inserido.set(true);
        GerenciadorValidacao.registrarRollback(() -> {
            System.out.println("Rollback - Removendo registro do DB para documento " + doc.getNumero());
            inserido.set(false);
        });

        doc.setAtributo("dbInserido", true);
        return ResultadoValidacao.ok();
    }

    @Override
    public int timeoutSegundos() { return 4; }

    @Override
    public String nome() { return "ValidadorBancoDados"; }
}
