public class AlgoritmoValueAtRisk implements AlgoritmoRisco {

    @Override
    public double calcular(ContextoRisco contexto) {
        double z = obterZScore(contexto.getNivelConfianca());
        double fatorDias = Math.sqrt(contexto.getHorizonteDias() / 252.0);
        double var = contexto.getValorCarteira() * contexto.getVolatilidade() * z * fatorDias;
        return Math.abs(var);
    }

    @Override
    public String nome() {
        return "Value at Risk";
    }

    private double obterZScore(double confianca) {
        if (confianca >= 0.995) return 2.5758;
        if (confianca >= 0.99)  return 2.3263;
        if (confianca >= 0.975) return 1.96;
        if (confianca >= 0.95)  return 1.6449;
        if (confianca >= 0.90)  return 1.2816;
        return 1.0;
    }
}
