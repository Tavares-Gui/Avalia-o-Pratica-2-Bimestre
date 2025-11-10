public class CalculadoraRisco {
    private AlgoritmoRisco algoritmo;

    public CalculadoraRisco(AlgoritmoRisco algoritmoInicial) {
        this.algoritmo = algoritmoInicial;
    }

    public void definirAlgoritmo(AlgoritmoRisco novoAlgoritmo) {
        this.algoritmo = novoAlgoritmo;
    }

    public double calcular(ContextoRisco contexto) {
        if (algoritmo == null) {
            throw new IllegalStateException("Nenhum algoritmo de risco foi definido.");
        }
        return algoritmo.calcular(contexto);
    }

    public String obterNomeAlgoritmo() {
        return algoritmo == null ? "Nenhum" : algoritmo.nome();
    }
}
