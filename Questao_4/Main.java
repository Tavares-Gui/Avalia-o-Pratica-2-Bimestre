package Questao_4;

public class Main {
    public static void main(String[] args) {
        DocumentoNF doc = new DocumentoNF("<NFe><.../></NFe>", "0001", "Chave_ok");

        GerenciadorValidacao ger = new GerenciadorValidacao();
        ger.adicionarValidador(new ValidadorSchemaXML());
        ger.adicionarValidador(new ValidadorCertificado());
        ger.adicionarValidador(new ValidadorRegrasFiscais());
        ger.adicionarValidador(new ValidadorBancoDados());
        ger.adicionarValidador(new ValidadorSEFAZ());

        System.out.println("Execucao 1: cenario OK ");
        ResultadoValidacao r1 = ger.executar(doc);
        System.out.println("Resultado final: " + r1);

        DocumentoNF docDup = new DocumentoNF("<NFe></NFe>", "DUPLICADO", "Chave_ok");
        System.out.println("\nExecucao 2: duplicidade no DB");
        ResultadoValidacao r2 = ger.executar(docDup);
        System.out.println("Resultado final: " + r2);

        DocumentoNF docSefazFail = new DocumentoNF("<NFe></NFe>", "0002", "SEFAZ_Fail");
        System.out.println("\nExecucao 3: SEFAZ retorna falha");
        ResultadoValidacao r3 = ger.executar(docSefazFail);
        System.out.println("Resultado final: " + r3);
    }
}
