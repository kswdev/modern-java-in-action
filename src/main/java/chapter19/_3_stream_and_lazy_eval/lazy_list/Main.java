package chapter19._3_stream_and_lazy_eval.lazy_list;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> l =
                new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));
    }
}
