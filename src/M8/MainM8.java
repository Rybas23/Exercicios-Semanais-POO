package src.M8;

import src.M3.StringsToText;

import java.util.*;

public class MainM8 {
    public static void main(String[] args) {
        //region 8.1
        System.out.println("8.1\n");

        Time time1 = new Time(25, 40);
        Time time2 = new Time("50:40");
        Time time3 = new Time(10, 5);
        Time time4 = new Time(5, 5);

        List<Time> timeList = new ArrayList<>();
        timeList.add(time1);
        timeList.add(time2);
        timeList.add(time3);
        timeList.add(time4);

        System.out.println("Lista Desordenada");
        for (Time time : timeList) {
            System.out.println(time);
        }

        TimeComparatorAsc timeComparatorAsc = new TimeComparatorAsc();
        timeList.sort(timeComparatorAsc);

        System.out.println("\nLista Crescente");
        for (Time time : timeList) {
            System.out.println(time);
        }

        TimeComparatorDesc timeComparatorDesc = new TimeComparatorDesc();

        timeList.sort(timeComparatorDesc);

        System.out.println("\nLista Decrescente");
        for (Time time : timeList) {
            System.out.println(time);
        }

        //endregion

        //region 8.2
        System.out.println("\n8.2\n");

        Aluno a1 = new Aluno("Ana", 1);
        Aluno a2 = new Aluno("Luís", 2);
        Aluno a3 = new Aluno("Rui", 3);
        Aluno a4 = new Aluno("Rita", 4);
        Aluno a5 = new Aluno("Maria", 5);

        HorarioDuvidas horarioDuvidas = new HorarioDuvidas();
        horarioDuvidas.marcacao(a1);
        horarioDuvidas.marcacao(a3);

        horarioDuvidas.chegada(a4);
        horarioDuvidas.chegada(a3);
        horarioDuvidas.chegada(a2);
        horarioDuvidas.chegada(a5);
        horarioDuvidas.chegada(a1);

        Aluno proxAluno = horarioDuvidas.proximo();
        while(proxAluno != null){
            System.out.println(proxAluno);
            proxAluno = horarioDuvidas.proximo();
        }

        //endregion

        //region 8.3
        System.out.println("\n8.3\n");

        List<Time> timeList1 = new ArrayList<>();
        timeList1.add(new Time(25, 40));
        boolean a = timeList1.contains(new Time(25, 40));
        boolean b = timeList1.contains(new Time(5,30));

        System.out.println("Lista 1 tests: " + a + ", " + b);

        //endregion

        //region 8.4
        System.out.println("\n8.4\n");

        try {
            System.out.println("Total words: " + Words.countWords());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //endregion

        //region 8.5
        System.out.println("\n8.5\n");

        try {
            SortedSet<String> words = Words.searchWords("lisboa", "livre");
            words.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //endregion

        //region 8.6
        System.out.println("\n8.6\n");

        try {
            Map<String, Integer> words = Words.topWords(5, 7);
            for (String word : words.keySet()) {
                System.out.println(word + ":" + words.get(word));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //endregion

        //region 8.7
        System.out.println("\n8.7\n");

        try {
            SortedMap<String, Integer> words = Words.searchWords2("lisboa", "livre");
            for (String word : words.keySet()) {
                System.out.println(word + ":" + words.get(word));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //endregion

        //region 8.8
        System.out.println("\n8.8\n");

        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");

        System.out.println("Stack:");
        arrayStack.forEach(System.out::println);

        System.out.println("\nStack size: " + arrayStack.size());
        System.out.println("Stack isEmpty: " + arrayStack.isEmpty());
        System.out.println("Stack pop: " + arrayStack.pop());
        System.out.println("Stack peek: " + arrayStack.peek() + "\n");

        System.out.println("Stack after pop:");
        arrayStack.forEach(System.out::println);

        String text = StringsToText.separatedBy2(arrayStack, ", ");
        System.out.println("\n" + text);

        //endregion
    }
}
