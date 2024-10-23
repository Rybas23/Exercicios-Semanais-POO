package src.M6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Interval implements Iterable<Integer>{
    //region Atributos

    private int min;
    private int max;

    //endregion

    //region Construtores

    public Interval(int min, int max) {
        this.min = min;
        this.max = max;
    }

    //endregion

    //region Getters and Setters

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    //endregion

    //region Métodos

    public static Interval naturals(int max) {
        return new Interval(1, max);
    }

    public static Interval arrayIndexes(int[] max) {
        return new Interval(0, max.length - 1);
    }

    public static Interval empty() {
        return new Interval(0, 0);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntervalIterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    //endregion

    //region Iterator

    private class IntervalIterator implements Iterator<Integer> {
        int currentValue = min;

        @Override
        public boolean hasNext() {
            return currentValue <= max;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return currentValue++;

        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    //endregion
}
