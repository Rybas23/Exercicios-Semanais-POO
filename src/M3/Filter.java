package src.M3;

import java.util.ArrayList;
import java.util.List;

/**
 * Filtro de listas
 */
public class Filter {
    /**
     * Filtra as palavras de uma lista pelo prefixo
     * @param list
     * @param prefix
     * @return
     */
    public static List<String> filterWordsPrefix(List<String> list, String prefix) {
        // Instancia uma nova lista que irá conter as palavras filtradas
        ArrayList<String> filtered = new ArrayList<>();

        // Percorre cada palavra da lista
        for(String word : list) {
            // Verifica se a palavra começa com o prefixo escolhido
            if(word.startsWith(prefix)) {
                // Adiciona a palvra à lista de palavras filtradas
                filtered.add(word);
            }
        }

        // Retorna a lista de palavras filtradas
        return filtered;
    }

    /**
     * Filtra as palavras de uma lista a partir do criterio de seleção escolhido
     * @param list
     * @param criterioDeSelecao
     * @return
     */
    public static List<String> filterWords(List<String> list, CriterioDeSelecao criterioDeSelecao) {
        // Instancia uma nova lista que irá conter as palavras filtradas
        ArrayList<String> filtered = new ArrayList<>();

        // Percorre cada palavra da lista
        for(String word : list) {
            // Verifica se a palavra cumpre com o criterio de seleção selecionado
            if(criterioDeSelecao.cumpreOCriterio(word)) {
                // Adiciona a palavra à lista de palavras filtradas
                filtered.add(word);
            }
        }

        // Retorna a lista de palavras filtradas
        return filtered;
    }

    //region Implementações Interface

    /**
     * Implementação da interface CriterioDeSelecao para quando o prefixo é a letra A
     */
    public static class PrefixA implements CriterioDeSelecao {
        /**
         * Verifica se o elemento cumpre com o criterio selecionado
         * @param elemento
         * @return
         */
        @Override
        public boolean cumpreOCriterio(Object elemento) {
            // Verifica se o elemento começa com o prefixo "A" e retorna o resultado
            return elemento.toString().startsWith("A");
        }
    }

    /**
     * Implementação da interface CriterioDeSelecao para quando o elemento tem menos de 3 caracteres
     */
    public static class SizeLess3 implements CriterioDeSelecao {
        /**
         * Verifica se o elemento cumpre com o criterio selecionado
         * @param elemento
         * @return
         */
        @Override
        public boolean cumpreOCriterio(Object elemento) {
            // Verifica se o elemento tem menos de 3 caracteres e retorna o resultado
            return elemento.toString().length() < 3;
        }
    }

    //endregion
}
