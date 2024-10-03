package src.M3;

/**
 * Interface Operador
 */
public interface Operator {
    /**
     * Retorna o simbolo da operação
     * @return
     */
    String getSymbol();

    /**
     * Realiza o calculo da respetiva operação
     * @param a
     * @param b
     * @return
     */
    int calculate(int a, int b);
}
