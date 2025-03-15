package chapter8._4_ConcurrentHashMap;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Reduce_Search_example {

    public static void main(String[] args) {
        // reduceValues 를 이용한 최댓값 찾기
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

        map.put("Tom", 10L);
        map.put("Jerry", 20L);
        map.put("John", 30L);
        map.put("Mike", 40L);
        map.put("Jane", 50L);
        map.put("Joe", 60L);
        map.put("Jill", 70L);
        map.put("Jack", 80L);
        map.put("Jenny", 90L);
        map.put("Johnny", 100L);
        map.put("Johnnie", 110L);
        map.put("Ace", 120L);

        long parallelismThreshold = 1;
        Optional<Long> maxValue =
                Optional.ofNullable(
                        map.reduceValues(parallelismThreshold, (e1, e2) -> {
                            System.out.println(Thread.currentThread().getName() + " : " + e1 + " , " + e2);
                            return Math.max(e1, e2);
                        })
                );

        System.out.println(maxValue);
    }
}
