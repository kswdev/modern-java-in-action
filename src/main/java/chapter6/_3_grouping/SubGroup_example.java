package chapter6._3_grouping;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class    SubGroup_example {

    public static void main(String[] args) {

        //메뉴에서 요리의 수를 종류별로 계산
        Map<Dish.Type, Long> countByType = DishExample.menu.stream()
                .collect(groupingBy(Dish::getType, counting()));

        //요리의 종류를 분류하는 컬렉터로 메뉴에서 가장 높은 칼로리를 가진 요리
        Map<Dish.Type, Optional<Dish>> maxCaloricDishByType = DishExample.menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));

        //요리의 종류를 분류하는 컬렉터로 메뉴에서 가장 높은 칼로리를 가진 요리: return Optional로 안 받기
        Map<Dish.Type, Dish> maxCaloricDishByType2 = DishExample.menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(
                                maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));

        System.out.println(maxCaloricDishByType2);
    }
}
