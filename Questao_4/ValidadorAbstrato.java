package Questao_4;

import java.util.concurrent.*;

public abstract class ValidadorAbstrato implements Validador {

    @Override
    public ResultadoValidacao validar(DocumentoNF doc) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<ResultadoValidacao> future = executor.submit(() -> executarValidacao(doc));

        try {
            ResultadoValidacao resultado = future.get(timeoutSegundos(), TimeUnit.SECONDS);
            return resultado;
        } catch (TimeoutException te) {
            future.cancel(true);
            return ResultadoValidacao.falha("Timeout apos " + timeoutSegundos() + "s");
        } finally {
            executor.shutdownNow();
        }
    }

    protected abstract ResultadoValidacao executarValidacao(DocumentoNF doc) throws Exception;

    @Override
    public boolean exigeAnteriorOk() { return false; }
}
