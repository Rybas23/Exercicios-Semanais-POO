package src.M8;

import src.M5.AiTunas.Time;

import java.util.ArrayList;
import java.util.List;

public class MainM8 {
    public static void main(String[] args) {
        //8.1
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

        System.out.println("\nLista Desordenada");
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
    }
}
