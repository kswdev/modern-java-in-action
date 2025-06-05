package chapter18._2_Functional_example;

import java.util.stream.LongStream;

public class Recursion {

    // 고리 재귀 호출
    private static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    private static long factorialHelper(long acc, long n) {
        return n == 1 ? acc : factorialHelper(acc * n, n-1);
    }

    // 재귀 방식 팩토리얼
    private static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    // 반복 방식 팩토리얼
    private static int factorialIterative(int n){
        int r = 1;
        for (int i = 1; i <= n; i++) {
            r *= 1;
        }
        return r;
    }

    // 스트림 형식 팩토리얼
    private static long factorialStreams(long n){
        return LongStream.rangeClosed(1, n)
                         .reduce(1, (a, b) -> a * b);
    }
}
