package chapter5._5_reducing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sum_example {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //for-each
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }

        //reduce-sum
        sum = numbers.stream().reduce(0, Integer::sum);
        int mul = numbers.stream().reduce(1, (a, b) -> a * b);

        //reduce-max, reduce-min
        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);

        Optional<Integer> min = numbers.stream()
                .reduce(Integer::min);
    }
}
