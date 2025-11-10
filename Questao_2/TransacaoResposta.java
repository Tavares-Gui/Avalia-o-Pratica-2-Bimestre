package Questao_2;

public class TransacaoResposta {
    private String status;
    private String codigoAutorizacao;
    private String mensagem;
    private String motivo;

    public TransacaoResposta(String status, String codigoAutorizacao, String mensagem, String motivo) {
        this.status = status;
        this.codigoAutorizacao = codigoAutorizacao;
        this.mensagem = mensagem;
        this.motivo = motivo;
    }

    public String getStatus() { return status; }
    public String getCodigoAutorizacao() { return codigoAutorizacao; }
    public String getMensagem() { return mensagem; }
    public String getMotivo() { return motivo; }

    @Override
    public String toString() {
        return "TransacaoResposta {" +
                "status='" + status + '\'' +
                ", codigoAutorizacao='" + codigoAutorizacao + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
