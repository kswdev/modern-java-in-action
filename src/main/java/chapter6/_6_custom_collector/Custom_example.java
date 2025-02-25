package chapter6._6_custom_collector;

import chapter6._4_partition.Partition_example;
import chapter6._6_custom_collector.collector.PrimeNumbersCollector;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class Custom_example {

    //소수 비소수 partitioningBy
    public static Map<Boolean, List<Integer>> partitionPrime(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(partitioningBy(Partition_example::isPrime));
    }

    //소수 비소수 커스텀 컬렉터
    public static Map<Boolean, List<Integer>> partitionPrimeCustom(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(new PrimeNumbersCollector());
    }
}
