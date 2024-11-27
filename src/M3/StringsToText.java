package src.M3;

import src.M8.ArrayStack;

import java.util.List;

/**
 * Classe que transforma ums lista de strings numa unica string, cada string da lista é sepradada por um separador
 */
public class StringsToText {
    /**
     * Transforma uma lista de strings numa unica string, cada string da lista é separada por um separador
     * @param strings
     * @param sep
     * @return
     */
    public static String separatedBy(List<String> strings, String sep ) {
       // Retorna a String com todas as strings da lista juntas e separadas por um separador
       return String.join(sep, strings);
    }

    public static String separatedBy2(ArrayStack<String> strings, String sep ) {
        // Retorna a String com todas as strings da lista juntas e separadas por um separador
        return String.join(sep, strings);
    }
}
