public class AlgoritmoStressTesting implements AlgoritmoRisco {

    @Override
    public double calcular(ContextoRisco contexto) {
        double perdaChoque = contexto.getExposicao() * contexto.getFatorChoque();
        double componenteVolatilidade = contexto.getValorCarteira() * contexto.getVolatilidade() * Math.sqrt(contexto.getHorizonteDias() / 252.0);
        double perdaTotal = Math.abs(perdaChoque) + Math.abs(componenteVolatilidade);
        return perdaTotal;
    }

    @Override
    public String nome() {
        return "Stress Testing";
    }
}
