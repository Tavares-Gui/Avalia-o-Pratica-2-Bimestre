package Questao_2;

public class TransacaoResposta {
    private String status;
    private String codigoAutorizacao;
    private String mensagem;

    public TransacaoResposta(String status, String codigoAutorizacao, String mensagem) {
        this.status = status;
        this.codigoAutorizacao = codigoAutorizacao;
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "Status: " + status +
               ", Codigo de Autorizacao: " + codigoAutorizacao +
               ", Mensagem: " + mensagem;
    }
}
