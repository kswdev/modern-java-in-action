package chapter2._3_simplize.filter;

import chapter2._3_simplize.predicate.Predicate;

import java.util.ArrayList;
import java.util.List;

public class _list_abstract {

    public static <T>List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();

        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}
