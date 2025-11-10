package Questao_4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ContextoValidacao {
    private int contadorFalhas = 0;
    private final int limiteFalhasCircuitBreaker = 3;
    private final Set<String> validadoresAPular = new HashSet<>();
    private final List<Validador> validadoresComRollback = new LinkedList<>();

    public void registrarFalha() {
        contadorFalhas++;
    }

    public boolean isCircuitBreakerAtivado() {
        return contadorFalhas >= limiteFalhasCircuitBreaker;
    }

    public int getContadorFalhas() {
        return contadorFalhas;
    }

    public void pularValidador(String nomeValidador) {
        if (nomeValidador != null) validadoresAPular.add(nomeValidador);
    }

    public boolean devePular(String nomeValidador) {
        return validadoresAPular.contains(nomeValidador);
    }

    public void registrarValidadorComRollback(Validador validador) {
        validadoresComRollback.add(validador);
    }

    public List<Validador> getValidadoresComRollback() {
        return validadoresComRollback;
    }
}
