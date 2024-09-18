package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Program {

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
    }

    // 1.2.a
    public static boolean isNumber(String s) {
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
        if (isNumber(s)) {
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

            if(isNumber(s)) {
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
        String frase = "";
        String keyWords = "";

        for(String s : strings) {
            keyWords += "" + s;
        }

        out.println("java FilterWords " + keyWords);

        do {
            frase = scanner.nextLine();
            out.println("frase: " + frase);
        }
        while (!scanner.nextLine().equals(""));

        scanner.close();
    }
}
