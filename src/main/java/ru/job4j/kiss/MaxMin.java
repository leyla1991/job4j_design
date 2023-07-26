package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return sorter(value, (o1, o2) -> comparator.compare(o1, o2) > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {

        return sorter(value, (o1, o2) -> comparator.compare(o1, o2) <= 0);
    }

    private  <T> T sorter(List<T> value, BiPredicate<T, T> predicate) {
        T rsl;
        if (!value.isEmpty()) {
            rsl = value.get(0);
            for (T t : value) {
                if (predicate.test(t, rsl)) {
                    rsl = t;
                }
            }
        } else {
            rsl = null;
        }
        return rsl;
    }
}
