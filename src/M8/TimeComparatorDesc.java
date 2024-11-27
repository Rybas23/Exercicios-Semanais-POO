package src.M8;

import java.util.Comparator;

public class TimeComparatorDesc implements Comparator<Time> {
    @Override
    public int compare(Time o1, Time o2) {
        if(o1.isGreaterThan(o2)) {
            return -1;
        } else if(o1.isLessThan(o2)) {
            return 1;
        }
        return 0;
    }
}
