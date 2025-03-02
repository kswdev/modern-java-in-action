package chapter7._1_parallel_stream;

import java.util.stream.LongStream;

import static common.Measure.measureAverage;

public class ProperUseOfParallelStream {

    private static final long N = 10_000_000L;

    public static void main(String[] args) {
        measureAverage(ProperUseOfParallelStream::sideEffectSum, 10, N);
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
