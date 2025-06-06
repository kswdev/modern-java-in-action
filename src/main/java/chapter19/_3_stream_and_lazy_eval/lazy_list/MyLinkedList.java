package chapter19._3_stream_and_lazy_eval.lazy_list;

import java.util.function.Predicate;

public class MyLinkedList<T> implements MyList<T> {

    private final T head;
    private final MyList<T> tail;

    public MyLinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail;
    }

    @Override
    public MyList<T> filter(Predicate<T> p) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
