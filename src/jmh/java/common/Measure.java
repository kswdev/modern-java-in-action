package common;

import chapter7._1_parallel_stream.ProperUseOfParallelStream;

import java.util.function.Function;

public abstract class Measure {

    private static long measurePerf(Function<Long, Long> function, long n) {
        long start = System.currentTimeMillis();
        function.apply(n);
        return System.currentTimeMillis() - start;
    }

    public static void measure(Function<Long, Long> function, int iterate, long n) {
        for (int i = 0; i < iterate; i++) {
            long result = function.apply(n);
            System.out.println("Result: " + result);
        }
        System.out.println("SideEffect parallel sum done in: " + measurePerf(ProperUseOfParallelStream::sideEffectSum, n) + " msecs");
    }
}
