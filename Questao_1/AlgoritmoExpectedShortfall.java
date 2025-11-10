public class AlgoritmoExpectedShortfall implements AlgoritmoRisco {

    private final AlgoritmoRisco algoritmoBase;

    public AlgoritmoExpectedShortfall(AlgoritmoRisco algoritmoBase) {
        this.algoritmoBase = algoritmoBase;
    }

    @Override
    public double calcular(ContextoRisco contexto) {
        double var = algoritmoBase.calcular(contexto);
        double es = var * 1.2;
        return Math.abs(es);
    }

    @Override
    public String nome() {
        return "Shortfall";
    }
}