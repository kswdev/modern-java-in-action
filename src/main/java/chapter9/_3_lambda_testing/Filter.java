package chapter9._3_lambda_testing;

import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static List<Integer> filter(List<Integer> tList, Predicate<Integer> predicate) {
        return tList.stream()
                .filter(predicate)
                .toList();
    }
}
