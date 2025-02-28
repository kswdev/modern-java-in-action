package common;

import java.util.function.Function;

public abstract class Measure {

    public static long measurePerf(Function<Long, Long> function, long n) {
        long start = System.currentTimeMillis();
        function.apply(n);
        return System.currentTimeMillis() - start;
    }
}
