package src.M8;

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

        Aluno a1 = new Aluno("TT", 1);
        Aluno a2 = new Aluno("TT", 2);
        Aluno a3 = new Aluno("TT", 3);
        Aluno a4 = new Aluno("TT", 4);
        Aluno a5 = new Aluno("TT", 5);

        HorarioDuvidas horarioDuvidas = new HorarioDuvidas();
        horarioDuvidas.marcacao(a3);
        horarioDuvidas.marcacao(a4);

        horarioDuvidas.chegada(a5);
        horarioDuvidas.chegada(a2);
        horarioDuvidas.chegada(a3);
        horarioDuvidas.chegada(a1);
        horarioDuvidas.chegada(a4);

        System.out.print("Marcações: ");
        int i = 0;
        for (Aluno aluno : horarioDuvidas.getMarcacoes()) {
            if (i == horarioDuvidas.getMarcacoes().size() - 1) {
                System.out.print(aluno);
            } else {
                System.out.print(aluno + ", ");
            }

            i++;
        }

        System.out.println("\n");

        System.out.print("Chegadas: ");
        i = 0;
        for (Aluno aluno : horarioDuvidas.getChegadas()) {
            if (i == horarioDuvidas.getChegadas().size() - 1) {
                System.out.print(aluno);
            } else {
                System.out.print(aluno + ", ");
            }

            i++;
        }

        System.out.println("\n");

        System.out.print("Atendimento: ");
        i = 0;
        for (Aluno aluno : horarioDuvidas) {
            if (i == horarioDuvidas.getPq().size() - 1) {
                System.out.print(horarioDuvidas.proximo());
            } else {
                System.out.print(horarioDuvidas.proximo() + ", ");
            }

            i++;
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
    }
}
