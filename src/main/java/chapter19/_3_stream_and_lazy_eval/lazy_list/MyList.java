package chapter19._3_stream_and_lazy_eval.lazy_list;

import java.util.function.Predicate;

public interface MyList<T> {
    T head();
    MyList<T> tail();
    MyList<T> filter(Predicate<T> p);
    default boolean isEmpty() { return true; }

}
