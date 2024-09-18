package src;

import static java.lang.System.out;

public class Program {

    public static void main(String[] args) {
        String[] output = {"0","2","3"};
        for(int i = 0; i < output.length;i++)
            out.println(output[i]);

        String test1 = "Sup";
        String test2 = "123";
        String test3 = "Sup123";

        out.println(isNumber(test1));
        out.println(isNumber(test2));
        out.println(isNumber(test3));
        out.println(toInt(test2));
    }

    public static boolean isNumber(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < 48 || s.charAt(i) > 57)
                return false;
        }
        return true;
    }

    public static int toInt(String s) {
        int aux = 0;
        if (isNumber(s)) {
            int casa = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                aux = s.charAt(i) - 48 * casa;
                casa *= 10;
            }
        }
        return aux;
    }

}
