package Questao_4;

/**
 * 2. Validador de Certificado Digital (expiração e revogação)
 * (Simulação: atributo "certValido" no documento ou checagem fictícia)
 */
public class ValidadorCertificado extends ValidadorAbstrato {

    @Override
    protected ResultadoValidacao executarValidacao(DocumentoNF doc) throws Exception {
        Object cert = doc.getAtributo("certificadoValido");
        if (cert instanceof Boolean && !(Boolean) cert) {
            return ResultadoValidacao.falha("Certificado expirado ou revogado");
        }
        doc.setAtributo("certificadoValido", true);
        return ResultadoValidacao.ok();
    }

    @Override
    public int timeoutSegundos() { return 3; }

    @Override
    public String nome() { return "ValidadorCertificado"; }
}
