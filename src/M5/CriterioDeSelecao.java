package src.M5;

/**
 * Interface para o Criterio de Seleção
 * @param <T>
 */
public interface CriterioDeSelecao<T> {
    /**
     * Verifica se cumpre o criterio de seleção
     * @param elemento
     * @return
     */
    boolean cumpreOCriterio(T elemento);
}
