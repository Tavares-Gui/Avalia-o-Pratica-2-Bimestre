package Questao_3;

public class UsinaNuclear {
    private EstadoUsina estadoAtual;

    private double temperatura;
    private double pressao;
    private double radiacao;
    private boolean sistemaResfriamentoAtivo;
    private boolean modoManutencao;
    private long tempoTemperaturaAlta;

    public UsinaNuclear() {
        this.estadoAtual = new EstadoDesligada();
        this.sistemaResfriamentoAtivo = true;
    }

    public void setEstado(EstadoUsina novoEstado) {
        System.out.println("Transicao de estado: " + estadoAtual.getNome() + " : " + novoEstado.getNome());
        this.estadoAtual = novoEstado;
    }

    public void atualizarCondicoes(double temperatura, double pressao, double radiacao, boolean sistemaResfriamentoAtivo, long tempoAlta) {
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.radiacao = radiacao;
        this.sistemaResfriamentoAtivo = sistemaResfriamentoAtivo;
        this.tempoTemperaturaAlta = tempoAlta;

        if (!modoManutencao) {
            estadoAtual.verificarCondicoes(this);
        } else {
            System.out.println("Modo manutencao - Estado ignorando transicoes automaticas.");
        }
    }

    public void ativarManutencao() {
        if (!modoManutencao) {
            modoManutencao = true;
            setEstado(new EstadoManutencao());
        } else {
            modoManutencao = false;
            setEstado(new EstadoOperacaoNormal());
        }
    }

    public double getTemperatura() { return temperatura; }
    public double getPressao() { return pressao; }
    public double getRadiacao() { return radiacao; }
    public boolean isSistemaResfriamentoAtivo() { return sistemaResfriamentoAtivo; }
    public long getTempoTemperaturaAlta() { return tempoTemperaturaAlta; }

    public EstadoUsina getEstadoAtual() {
        return estadoAtual;
    }
}
