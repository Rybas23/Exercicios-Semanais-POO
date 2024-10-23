package src.M6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Week implements Iterable<WeekDay>{
    //region Atributos

    private WeekDay[] weekDays;

    //endregion

    //region Construtores

    public Week() {
        this.weekDays = new WeekDay[7];
        weekDays[0] = new WeekDay("MONDAY");
        weekDays[1] = new WeekDay("TUESDAY");
        weekDays[2] = new WeekDay("WEDNESDAY");
        weekDays[3] = new WeekDay("THURSDAY");
        weekDays[4] = new WeekDay("FRIDAY");
        weekDays[5] = new WeekDay("SATURDAY");
        weekDays[6] = new WeekDay("SUNDAY");
    }

    @Override
    public Iterator<WeekDay> iterator() {
        return new WeekDayIterator();
    }

    //endregion

    private class WeekDayIterator implements Iterator<WeekDay> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < weekDays.length;
        }

        @Override
        public WeekDay next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            WeekDay weekDay = weekDays[index];
            index++;

            return weekDay;
        }
    }
}
