package chapter6._5_collector;

import chapter6._5_collector.collector.ToListCollector;
import common.dish.Dish;
import common.dish.DishExample;

import java.util.ArrayList;
import java.util.List;

public class Collector_example {


    public static void main(String[] args) {

        ToListCollector<Integer> collector = new ToListCollector<>();

        //시작
        List<Integer> integers = collector.supplier().get();

        //스트림에 남아있는 요소가 없을때 까지
        collector.accumulator().accept(integers, 1);

        //결과
        List<Integer> result = collector.finisher().apply(integers);


        //서브 스트림1
        List<Integer> result1 = collector.finisher().apply(List.of(1, 2, 3));
        //서브 스트림2
        List<Integer> result2 = collector.finisher().apply(List.of(4, 5, 6));

        List<Integer> combinedResults = collector.combiner().apply(result1, result2);


        List<Dish> dishes = DishExample.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(new ToListCollector<>());

        List<Dish> dishes2 = DishExample.menu.stream()
                .collect(ArrayList::new
                        ,ArrayList::add
                        ,ArrayList::addAll);
    }
}
