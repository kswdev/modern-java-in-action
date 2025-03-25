package chapter9._3_lambda_testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static chapter9._3_lambda_testing.Filter.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterTest {

    @Test
    void testFilter() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<Integer> even = filter(numbers, n -> n % 2 == 0);
        List<Integer> smallerThanThree = filter(numbers, n -> n < 3);
        assertEquals(List.of(2, 4), even);
        assertEquals(List.of(1, 2), smallerThanThree);
    }
}