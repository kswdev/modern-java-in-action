package chapter7._2_fork_join_framework;

import chapter7._2_fork_join_framework.forkJoin.ForkJoinSumCalculator;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import static common.Measure.measureAverage;

public class ForkJoinSum_example {

    private static final long N = 10_000_000L;

    public static void main(String[] args) {
        measureAverage(ForkJoinSum_example::forkJoinSum, 10, N);
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
