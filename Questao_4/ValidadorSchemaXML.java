package Questao_4;

public class ValidadorSchemaXML extends ValidadorAbstrato {
    @Override
    protected ResultadoValidacao executarValidacao(DocumentoNF doc) throws Exception {
        String xml = doc.getXml();
        if (xml == null || !xml.contains("<NFe")) {
            return ResultadoValidacao.falha("XML invalido: tag <NFe> ausente");
        }
        doc.setAtributo("schemaValido", true);
        return ResultadoValidacao.ok();
    }

    @Override
    public int timeoutSegundos() { return 5; }

    @Override
    public String nome() { return "ValidadorSchemaXML"; }
}
