package chapter6._2_reducing_and_summation;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.Optional;
import java.util.stream.Collectors;

public class ReducingSummation_example {

    public static void main(String[] args) {
        int totalCalories = DishExample.menu.stream()
                .collect(Collectors.reducing(
                        0, Dish::getCalories, (a, b) -> a + b));

        Optional<Dish> maxCalories = DishExample.menu.stream()
                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
    }
}
