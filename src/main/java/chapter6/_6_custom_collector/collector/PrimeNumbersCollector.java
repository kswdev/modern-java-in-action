package chapter6._6_custom_collector.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class PrimeNumbersCollector
        implements Collector<Integer,
                            Map<Boolean, List<Integer>>,
                            Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<>() {{
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
        }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (acc, num) -> {
            acc.get(isPrime(acc.get(true), num))
                    .add(num);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (acc1, acc2) -> new HashMap<>() {{
            acc1.get(true).addAll(acc2.get(true));
            acc1.get(false).addAll(acc2.get(false));
        }};
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.IDENTITY_FINISH);
    }

    public static boolean isPrime(List<Integer> primes, int num) {
        int numRoot = (int) Math.sqrt(num);
        return primes.stream()
                .takeWhile(i -> i <= numRoot)
                .noneMatch(i -> num % i == 0);
    }
}
