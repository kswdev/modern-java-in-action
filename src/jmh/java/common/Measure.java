package common;

import java.util.function.Function;

public abstract class Measure {

    private static long measurePerf(Function<Long, Long> function, long n) {
        long start = System.currentTimeMillis();
        System.out.println("Result: " + function.apply(n));
        return System.currentTimeMillis() - start;
    }

    public static void measureAverage(Function<Long, Long> function, int iterate, long n) {
        long result = 0;
        for (int i = 0; i < iterate; i++) {
            result += measurePerf(function, n);
        }
        result /= iterate;
        System.out.println("SideEffect parallel sum done in: " + result + " msecs");
    }
}
