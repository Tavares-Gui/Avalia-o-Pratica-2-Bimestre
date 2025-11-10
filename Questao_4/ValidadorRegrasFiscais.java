package Questao_4;

public class ValidadorRegrasFiscais extends ValidadorAbstrato {

    @Override
    protected ResultadoValidacao executarValidacao(DocumentoNF doc) throws Exception {
        boolean ok = true;
        Object calc = doc.getAtributo("impostoCalculado");
        if (calc == null || !(Boolean) calc) {
            Thread.sleep(500);
            doc.setAtributo("impostoCalculado", true);
            doc.setAtributo("valorImposto", 123.45);
        }
        return ok ? ResultadoValidacao.ok() : ResultadoValidacao.falha("Erro no calculo de impostos");
    }

    @Override
    public int timeoutSegundos() { return 7; }

    @Override
    public String nome() { return "ValidadorRegrasFiscais"; }

    @Override
    public boolean exigeAnteriorOk() { return true; }
}
