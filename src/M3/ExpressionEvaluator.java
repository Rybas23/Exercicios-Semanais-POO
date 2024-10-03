package src.M3;

import src.M1.MainM1;

import java.util.ArrayList;
import java.util.List;

/**
 * Avaliador de expressões
 */
public class ExpressionEvaluator {
    //region Atributos

    private List<Operator> operatorList;
    private List<Integer> numberList = new ArrayList<>();
    private List<String> op = new ArrayList<>();

    //endregion

    // Construtores

    /**
     * Construtor Completo
     * @param operatorList
     */
    public ExpressionEvaluator(List<Operator> operatorList) {
        this.operatorList = operatorList;
    }

    //endregion

    //region Métodos

    /**
     * Avalia a expressão e realiza o calculo
     * @param expression
     * @return
     */
    public int evaluate(String[] expression) {
        // Percorre cada string do array da expressão
        for(String s : expression) {
            // Verifica se a string é um numero
            if(MainM1.isInteger(s)) {
                // Adiciona o número à lista
                numberList.add(MainM1.toInt(s));
            }
            // Verifica se a string é uma operação
            else if(isOp(s)) {
                // Adiciona a operação à lista de operações
                op.add(s);
            }
            // Verifica se é parentesis finais
            else if(s.equals(")")) {
                // Realiza o calculo de uma parcela da expressão
                numberList.add(operate());
            }
        }

        // Retorna o resultado da expressão
        return numberList.get(0);
    }

    /**
     * Realiza o calculo para cada operação
     * @return
     */
    private int operate() {
        // Vai ver a lista de operações encontradas a ultima operação adicionada
        // guarda-a numa variavel e remove-a da lista
        String top = op.get(op.size() - 1);
        op.remove(op.size() - 1);

        // Vai ver a lista de números encontrados o último número adicionado
        // guarda-o numa variavel e elemina-o da lista
        int a = numberList.get(numberList.size() - 1);
        numberList.remove(numberList.size() - 1);

        // Vai ver a lista de números encontrados o último número adicionado
        // guarda-o numa variavel e elemina-o da lista
        int b = numberList.get(numberList.size() - 1);
        numberList.remove(numberList.size() - 1);

        // Percorre cada operação
        for(Operator o : operatorList) {
            // Verifica se a operação selecionada existe na lista
            if(top.equals(o.getSymbol())) {
                // Caso exista realiza o calculo
                return o.calculate(b, a);
            }
        }

        // Retorna zero caso não seja feito nenhum calculo
        return 0;
    }

    /**
     * Verifica se é uma operação ou não
     * @param c
     * @return
     */
    private boolean isOp(String c) {
        // Passa por cada operação da lista de operações
        for(Operator o : operatorList) {
            // Compara o simbolo recebeido com o simbolo da operação
            if(c.equals(o.getSymbol())) {
                // Devolve true caso a operação seja encontrada
                return true;
            }
        }

        // Devolve false caso não seja uma operação
        return false;
    }

    //endregion

    //region Implementações Interfaces

    /**
     * Implementação da Potência
     */
    public static class Power implements Operator {

        /**
         * Devolve o simbolo da operação
         * @return
         */
        @Override
        public String getSymbol() {
            return "^";
        }

        /**
         * Realiza o calculo relativo à operação
         * @param a
         * @param b
         * @return
         */
        @Override
        public int calculate(int a, int b) {
            return (int) Math.pow(a, b);
        }
    }

    /**
     * Implementação da Adição
     */
    public static class Addition implements Operator {
        /**
         * Devolve o simbolo da operação
         * @return
         */
        @Override
        public String getSymbol() {
            return "+";
        }

        /**
         * Realiza o calculo relativo à operação
         * @param a
         * @param b
         * @return
         */
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    }

    /**
     * Implementação da Subtração
     */
    public static class Subtraction implements Operator {
        /**
         * Devolve o simbolo da operação
         * @return
         */
        @Override
        public String getSymbol() {
            return "-";
        }

        /**
         * Realiza o calculo relativo à operação
         * @param a
         * @param b
         * @return
         */
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    }

    /**
     * Implementação da Divisão
     */
    public static class Division implements Operator {
        /**
         * Devolve o simbolo da operação
         * @return
         */
        @Override
        public String getSymbol() {
            return "/";
        }

        /**
         * Realiza o calculo relativo à operação
         * @param a
         * @param b
         * @return
         */
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
    }

    /**
     * Implementação da Multiplicação
     */
    public static class Multipication implements Operator {
        /**
         * Devolve o simbolo da operação
         * @return
         */
        @Override
        public String getSymbol() {
            return "*";
        }

        /**
         * Realiza o calculo relativo à operação
         * @param a
         * @param b
         * @return
         */
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    }

    //endregion
}
