package src.M5;

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
}
