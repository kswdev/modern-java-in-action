package chapter6._2_reducing_and_summation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DifferenceReduceAndCollect_example {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> list = stream.reduce(
                new ArrayList<>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1;
                }
        );
    }
}
