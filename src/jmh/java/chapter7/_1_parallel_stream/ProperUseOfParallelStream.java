package chapter7._1_parallel_stream;

import java.util.stream.LongStream;

import static common.Measure.measurePerf;

public class ProperUseOfParallelStream {

    private static final long N = 10_000_000L;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long result = sideEffectSum(N);
            System.out.println("Result: " + result);
        }
        System.out.println("SideEffect parallel sum done in: " + measurePerf(ProperUseOfParallelStream::sideEffectSum, 10_000_000L) + " msecs");
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(0L, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    private static class Accumulator {
        public long total = 0;

        private void add(long value) { total += value; }
    }
}
