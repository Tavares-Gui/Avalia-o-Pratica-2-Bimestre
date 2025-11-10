public class Main {
    public static void main(String[] args) {
        ContextoRisco contexto = new ContextoRisco.Construtor()
                .valorCarteira(5_000_000.0)
                .volatilidade(0.18)
                .nivelConfianca(0.99)
                .exposicao(2_000_000.0)
                .fatorChoque(0.25)
                .horizonteDias(10)
                .construir();

        AlgoritmoValueAtRisk var = new AlgoritmoValueAtRisk();
        AlgoritmoExpectedShortfall es = new AlgoritmoExpectedShortfall(var);
        AlgoritmoStressTesting stress = new AlgoritmoStressTesting();

        CalculadoraRisco calculadora = new CalculadoraRisco(var);
        System.out.printf("Algoritmo : %s : Resultado: R$ %.2f%n",
                calculadora.obterNomeAlgoritmo(), calculadora.calcular(contexto));

        calculadora.definirAlgoritmo(es);
        System.out.printf("Algoritmo : %s : Resultado: R$ %.2f%n",
                calculadora.obterNomeAlgoritmo(), calculadora.calcular(contexto));

        calculadora.definirAlgoritmo(stress);
        System.out.printf("Algoritmo : %s : Resultado: R$ %.2f%n",
                calculadora.obterNomeAlgoritmo(), calculadora.calcular(contexto));
    }
}
