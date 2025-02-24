package chapter6._3_grouping;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Partition_example {


    public static void main(String[] args) {

        //partitionBy
        Map<Boolean, List<Dish>> menuPartitionedByVegetarian = DishExample.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        //두 번째 인수로 컬렉터 넘기기
        Map<Boolean, Map<Dish.Type, List<Dish>>> menuPartitionedByVegetarianAndType = DishExample.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println(partitionPrime(10));
    }

    //소수/비소수
    public static Map<Boolean, List<Integer>> partitionPrime(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(partitioningBy(Partition_example::isPrime));
    }

    public static boolean isPrime(int num) {
        int numRoot = (int) Math.sqrt(num);
        return IntStream.rangeClosed(2, numRoot)
                .noneMatch(i -> num % i == 0);
    }
}
