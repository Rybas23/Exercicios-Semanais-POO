package src.M3;

import java.util.ArrayList;

public class SortedIntArray {
    //region Atributos

    private ArrayList<Integer> array;
    private SortingPolicy policy;

    //endregion

    //region Construtores

    /**
     * Construtor Completo
     * @param policy
     */
    public SortedIntArray(SortingPolicy policy) {
        this.array = new ArrayList<>();
        this.policy = policy;
    }

    //endregion

    //region Métodos

    /**
     * Devolve o tamanho do array
     * @return
     */
    public int size() {
        return array.size();
    }

    /**
     * Adiciona um novo elemento ao array
     * @param element
     */
    public void add(int element) {
        // Verifica se o array está vazio
        if(array.isEmpty()) {
            // Insere o primeiro elemento
            array.add(element);
        } else {
            // Percorre cada elemento do array até encontrar a posição certa
            for(int index = 0; index < array.size(); index++) {
                // Verifica se é a posição certa
                if(policy.isBefore(element, get(index))) {
                    // Adiciona o novo elemento à posição colocada
                    array.add(index, element);
                    return;
                }
            }
        }
    }

    /**
     * Devolve o element que está na posição pedida do array
     * @param index
     * @return
     */
    public int get(int index) {
        // Devolve o elemento da posição selecionada do array
        return array.get(index);
    }

    //endregion

    //region Implementação Interface

    public static class Descending implements SortingPolicy{
        /**
         * Esta implementação do método serve para organizar o array de forma decrescente
         * @param a
         * @param b
         * @return
         */
        @Override
        public boolean isBefore(int a, int b) {
            return a > b;
        }

    }

    //endregion
}
