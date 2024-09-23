package src.M1;

import java.util.*;

import static java.lang.System.out;

public class MainM1 {

    public static void main(String[] args) {
        /*String[] output = {"0","2","3"};
        for(int i = 0; i < output.length;i++)
            out.println(output[i]);*/

        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("123");
        strings.add("34565");
        strings.add("7654");

        checkInts(strings);

        out.println(" ");

        List<String> strings2 = new ArrayList<>();
        strings2.add("Olá");
        strings2.add("Juro");
        strings2.add("batata");

        //filterWords(strings2);

        List<String> strings3 = new ArrayList<>();
        strings3.add("teste");
        strings3.add("batata");

        //characterCount(strings3);

        List<String> strings4 = new ArrayList<>();
        strings4.add("(");
        strings4.add("1");
        strings4.add("+");
        strings4.add("(");
        strings4.add("(");
        strings4.add("2");
        strings4.add("+");
        strings4.add("3");
        strings4.add(")");
        strings4.add("x");
        strings4.add("(");
        strings4.add("4");
        strings4.add("x");
        strings4.add("5");
        strings4.add(")");
        strings4.add(")");
        strings4.add(")");

        expressionEvaluator(strings4);
    }

    // 1.2.a
    public static boolean isInteger(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < 48 || s.charAt(i) > 57)
                return false;
        }
        return true;
    }

    // 1.2.b
    public static int toInt(String s) {
        int aux = 0;
        int result = 0;
        if (isInteger(s)) {
            int multiplier = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                aux = (s.charAt(i) - 48) * multiplier;
                result += aux;
                multiplier *= 10;
            }
        }
        return result;
    }

    // 1.2.c
    public static void checkInts(List<String> strings) {
        int somatorio = 0;
        int countPos = 0;
        int countNeg = 0;

        String textInicial = "";

        for (String s : strings) {
            textInicial += " " + s;

            if(isInteger(s)) {
                countPos++;
            } else {
                countNeg++;
            }

            somatorio += toInt(s);
        }

        out.println("java CheckIntegers " + textInicial);
        out.println("Encontrei " + countPos + " inteiros");
        out.println("Encontrei " + countNeg + " termos não inteiros");
        out.println("Somatorio dos inteiros: " + somatorio);
    }

    //1.3
    public static void filterWords(List<String> strings) {
        Scanner scanner = new Scanner(System.in);
        String frase = " ";
        String newString;
        boolean phraseFlag = false;

        out.println("java FilterWords " + strings);

        do {
            newString = "";
            frase = scanner.nextLine();

            if(frase.equals("")) {
                break;
            }

            out.println("frase: " + frase);

            for (String word : frase.split(" ")) {
                for (String keyWord : strings) {
                    if (word.equals(keyWord)) {
                        phraseFlag = true;
                        break;
                    }
                }

                if (!phraseFlag) {
                    newString += word + " ";
                }

                phraseFlag = false;
            }

            out.println("filtrada: " + newString);
            out.println(" ");
        } while (!frase.equals(""));

        scanner.close();
    }

    //1.4
    public static void characterCount(List<String> strings) {
        CharacterData characterData = new CharacterData();
        out.println("java CharacterStats " + strings);

        for (String s : strings) {
            characterData.addWord(s);
        }

        for (Map.Entry<Character, Integer> character : characterData.characterCount.entrySet()) {
            double percentage = ((double) character.getValue() / (double) characterData.getTotal()) * 100;

            System.out.println(character.getKey() + ": " + character.getValue() + " (" + percentage + "%)");
        }
    }

    // 1.5
    public static void expressionEvaluator(List<String> strings) {
        out.println("java ExpressionEvaluator " + strings);
        
        Dijkstra d = new Dijkstra(strings);

        d.execute();
        System.out.println(d.result());
    }

}
