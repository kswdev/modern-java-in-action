package chapter19._3_stream_and_lazy_eval.lazy_list;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class LazyList<T> implements MyList<T> {
    private final T head;
    private final Supplier<MyList<T>> tail;

    public LazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    public static <T> void printAll(MyList<T> list) {
        if (list.isEmpty()) return;
        System.out.println(list.head());
        printAll(list.tail());
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail.get();
    }

    @Override
    public MyList<T> filter(Predicate<T> p) {
        return isEmpty() ?
                this :
                p.test(head()) ?
                    new  LazyList<>(head(), () -> tail().filter(p)) :
                    tail().filter(p);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
