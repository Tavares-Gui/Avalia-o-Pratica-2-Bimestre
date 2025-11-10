package Questao_4;

public class ValidadorSEFAZ extends ValidadorAbstrato {
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoNF doc) throws Exception {
        Thread.sleep(1000);
        if ("SEFAZ_FAIL".equals(doc.getChave())) {
            return ResultadoValidacao.falha("SEFAZ: rejeitado/indisponível");
        }
        doc.setAtributo("sefazConsulta", "OK");
        return ResultadoValidacao.ok();
    }

    @Override
    public int timeoutSegundos() { return 6; }

    @Override
    public String nome() { return "ValidadorSEFAZ"; }

    @Override
    public boolean exigeAnteriorOk() { return true; }
}
