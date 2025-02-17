package chapter5._6_number_stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Range_example {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        Stream<double []> stream = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(1, 100).boxed()
                                .map(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0));
    }
}
