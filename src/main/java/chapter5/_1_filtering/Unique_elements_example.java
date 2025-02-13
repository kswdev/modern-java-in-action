package chapter5._1_filtering;

import java.util.Arrays;
import java.util.List;

public class Unique_elements_example {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 2, 2, 5, 1);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
