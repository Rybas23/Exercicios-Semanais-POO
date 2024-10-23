package src.M6;

import java.util.*;
import java.util.function.Predicate;

public class MainM6 {
    public static void main(String[] args) {
        //region 6.2
        System.out.println("6.2\n");

        ArrayList<Integer> listaInts = new ArrayList<>();
        listaInts.add(1);
        listaInts.add(2);
        listaInts.add(3);
        listaInts.add(4);
        listaInts.add(5);
        listaInts.add(6);
        listaInts.add(7);
        listaInts.add(8);
        listaInts.add(9);
        listaInts.add(10);
        System.out.println("Average ArrayList: " + average(listaInts));

        LinkedList<Integer> listaInts2 = new LinkedList<>();
        listaInts2.add(1);
        listaInts2.add(2);
        listaInts2.add(3);
        listaInts2.add(4);
        listaInts2.add(5);
        listaInts2.add(6);
        listaInts2.add(7);
        listaInts2.add(8);
        listaInts2.add(9);
        listaInts2.add(10);
        System.out.println("Average LinkedList: " + average(listaInts2));

        //endregion

        //region 6.3
        System.out.println("\n6.3\n");

        Interval test = new Interval(5, 7);
        test.forEach(System.out::println);

        System.out.println("Average: " + average(test));

        //endregion

        //region 6.4
        System.out.println("\n6.4\n");

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("");
        list.add("b");
        list.add("");

        Iterable<String> nonEmpty = select(list, s -> !s.isEmpty()); // {"a","b"}

        nonEmpty.forEach(System.out::println);

        //endregion

        //region 6.5
        System.out.println("\n6.5\n");

        List<String> listStrings = new ArrayList<>();
        listStrings.add("Teste");
        listStrings.add("Teste2");
        listStrings.add("Teste34");
        listStrings.add("Teste0");

        List<Integer> listIntegers = new ArrayList<>();
        listIntegers.add(0);
        listIntegers.add(1);
        listIntegers.add(2);

        Iterable<String> stringMatchesNumber = select2(listStrings, s -> s.contains("2"));
        stringMatchesNumber.forEach(System.out::println);

        Iterable<Integer> matchesNumber = select2(listIntegers, n -> (n == 2));
        matchesNumber.forEach(System.out::println);

        //endregion

        //region 6.6
        System.out.println("\n6.6\n");

        String[] stringArray = new String[5];
        stringArray[0] = "A";
        stringArray[1] = "B";
        stringArray[2] = "C";
        stringArray[3] = "D";
        stringArray[4] = "E";

        ArrayIterator stringIterator = new ArrayIterator(stringArray);

        while(stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }

        Integer[] intArray = new Integer[5];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;
        intArray[3] = 4;
        intArray[4] = 5;

        System.out.println("");

        ArrayIterator intIterator = new ArrayIterator(intArray);

        while(intIterator.hasNext()) {
            System.out.println(intIterator.next());
        }

        //endregion

        //region 6.7
        System.out.println("\n6.7\n");

        Week week = new Week();
        for(WeekDay w: week) {
            System.out.println(w);
        }

        //endregion
    }

    /**
     * 6.2
     * @param iterable
     * @return
     */
    public static double average(Iterable<Integer> iterable) {
        if(iterable == null) {
            throw new NullPointerException("iterable is null");
        }

        try {
            int sum = 0;
            int count = 0;

            Iterator<Integer> it = iterable.iterator();

            while (it.hasNext()) {
                sum += it.next();
                count++;
            }

            return (double) sum / count;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return 0;
        }
    }

    /**
     * 6.4
     * @param iterable
     * @param pred
     * @return
     */
    static Iterable<String> select(Iterable<String> iterable, Predicate<String> pred) {
        if(iterable == null || pred == null) {
            throw new NullPointerException("iterable or predicate is null");
        }

        try {
            ArrayList<String> result = new ArrayList<>();

            for (String s : iterable) {
                if (pred.test(s)) {
                    result.add(s);
                }
            }

            return result;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
    }

    /**
     * 6.5
     * @param it
     * @param pred
     * @return
     * @param <T>
     */
    static <T> Iterable<T> select2(Iterable<T> it, Predicate<T> pred) {
        if(it == null || pred == null) {
            throw new NullPointerException("iterable or predicate is null");
        }

        try {
            ArrayList<T> result = new ArrayList<>();

            for (T t : it) {
                if (pred.test(t)) {
                    result.add(t);
                }
            }

            return result;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
    }
}
