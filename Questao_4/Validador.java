package Questao_4;

public interface Validador {
    ResultadoValidacao validar(DocumentoNF doc) throws Exception;
    int timeoutSegundos();
    String nome();
    boolean exigeAnteriorOk();
}
