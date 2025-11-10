package Questao_4;

public class ResultadoValidacao {
    private boolean ok;
    private String mensagem;

    private ResultadoValidacao(boolean ok, String mensagem) {
        this.ok = ok;
        this.mensagem = mensagem;
    }

    public static ResultadoValidacao ok() { return new ResultadoValidacao(true, "OK"); }
    public static ResultadoValidacao falha(String msg) { return new ResultadoValidacao(false, msg); }

    public boolean isOk() { return ok; }
    public String getMensagem() { return mensagem; }

    @Override
    public String toString() { return (ok ? "OK" : "FALHA") + " - " + mensagem; }
}
