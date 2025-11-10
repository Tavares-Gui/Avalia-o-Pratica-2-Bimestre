public final class ContextoRisco {
    private final double valorCarteira;
    private final double volatilidade;
    private final double nivelConfianca;
    private final double exposicao;
    private final double fatorChoque;
    private final int horizonteDias;

    private ContextoRisco(Construtor construtor) {
        this.valorCarteira = construtor.valorCarteira;
        this.volatilidade = construtor.volatilidade;
        this.nivelConfianca = construtor.nivelConfianca;
        this.exposicao = construtor.exposicao;
        this.fatorChoque = construtor.fatorChoque;
        this.horizonteDias = construtor.horizonteDias;
    }

    public double getValorCarteira() { return valorCarteira; }
    public double getVolatilidade() { return volatilidade; }
    public double getNivelConfianca() { return nivelConfianca; }
    public double getExposicao() { return exposicao; }
    public double getFatorChoque() { return fatorChoque; }
    public int getHorizonteDias() { return horizonteDias; }

    public static class Construtor {
        private double valorCarteira;
        private double volatilidade;
        private double nivelConfianca = 0.95;
        private double exposicao;
        private double fatorChoque;
        private int horizonteDias = 1;

        public Construtor valorCarteira(double valorCarteira) {
            this.valorCarteira = valorCarteira; return this;
        }
        public Construtor volatilidade(double volatilidade) {
            this.volatilidade = volatilidade; return this;
        }
        public Construtor nivelConfianca(double nivelConfianca) {
            this.nivelConfianca = nivelConfianca; return this;
        }
        public Construtor exposicao(double exposicao) {
            this.exposicao = exposicao; return this;
        }
        public Construtor fatorChoque(double fatorChoque) {
            this.fatorChoque = fatorChoque; return this;
        }
        public Construtor horizonteDias(int horizonteDias) {
            this.horizonteDias = horizonteDias; return this;
        }

        public ContextoRisco construir() {
            return new ContextoRisco(this);
        }
    }
}
