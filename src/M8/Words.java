package src.M8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Words {
    public static int countWords() throws FileNotFoundException {
        Set<String> wordSet = new HashSet<String>();

        Scanner scanner = new Scanner(new File("OsMaias-Cap1.txt"), "UTF-8");
        scanner.useDelimiter("[,\\.;:\\-\\?!»«\\(\\)0-9\\s]+");
        while(scanner.hasNext()) {
            String word = scanner.next();
            word = word.toLowerCase();
            wordSet.add(word);
        }

        scanner.close();

        return wordSet.size();
    }

    public static SortedSet<String> searchWords(String word1, String word2) throws FileNotFoundException {
        SortedSet<String> sortedWordSet = new TreeSet<>();

        Scanner scanner = new Scanner(new File("OsMaias-Cap1.txt"), "UTF-8");
        scanner.useDelimiter("[,\\.;:\\-\\?!»«\\(\\)0-9\\s]+");
        while(scanner.hasNext()) {
            String word = scanner.next();
            word = word.toLowerCase();

            if(word.length() > 3) {
                sortedWordSet.add(word);
            }
        }

        scanner.close();

        return sortedWordSet.subSet(word1, word2);
    }

    public static Map<String, Integer> topWords(int m, int n) throws FileNotFoundException {
        Map<String, Integer> wordMap = new HashMap<>();
        Map<String, Integer> sortedWordMap = new HashMap<>();

        Scanner scanner = new Scanner(new File("OsMaias-Cap1.txt"), "UTF-8");
        scanner.useDelimiter("[,\\.;:\\-\\?!»«\\(\\)0-9\\s]+");
        while(scanner.hasNext()) {
            String word = scanner.next();
            word = word.toLowerCase();

            if(word.length() >= m) {
                if (wordMap.containsKey(word)) {
                    wordMap.put(word, wordMap.get(word) + 1);
                } else {
                    wordMap.put(word, 1);
                }
            }
        }

        scanner.close();

        sortedWordMap = sortByValue(wordMap, false, n);

        return sortedWordMap;
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order, int n)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.subList(0,n).stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
    }

    public static SortedMap<String, Integer> searchWords2(String word1, String word2) throws FileNotFoundException {
        SortedMap<String, Integer> map = new TreeMap<>();

        Scanner scanner = new Scanner(new File("OsMaias-Cap1.txt"), "UTF-8");
        scanner.useDelimiter("[,\\.;:\\-\\?!»«\\(\\)0-9\\s]+");
        while(scanner.hasNext()) {
            String word = scanner.next();
            word = word.toLowerCase();

            if(word.length() > 3) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        scanner.close();

        return map.subMap(word1, word2);
    }
}