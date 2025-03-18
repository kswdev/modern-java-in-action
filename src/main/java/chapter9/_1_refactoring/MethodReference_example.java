package chapter9._1_refactoring;

import common.apple.Apple;
import common.dish.CaloricLevel;
import common.dish.Dish;
import common.dish.DishExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class MethodReference_example {

    private static final List<Apple> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = DishExample.menu.stream().collect(
                groupingBy((dish) ->{
                    if (dish.getCalories() < 400){ return CaloricLevel.DIET; }
                    else if (400 < dish.getCalories() && dish.getCalories() < 700){ return CaloricLevel.NORMAL; }
                    else { return CaloricLevel.FAT; }
                })
        );

        //메서드 참조
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevelWithMethodReference = DishExample.menu.stream().collect(
                groupingBy(DishExample::getCaloricLevel)
        );

        //static helper method : comparing, maxBy
        inventory.sort((Apple a1, Apple a2) ->
                a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort(comparing(Apple::getWeight));

        // 저수준 리듀싱 연산에서 메서드 참조
        int totalCalories =
                DishExample.menu.stream().map(Dish::getCalories)
                                         .reduce(0, (c1, c2) -> c1 + c2);

        int totalCaloriesWithMethodReference =
                DishExample.menu.stream().collect(summingInt(Dish::getCalories));
    }
}
