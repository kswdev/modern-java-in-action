package chapter6._2_max_min;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxMinExample {

    public static void main(String[] args) {
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish =
                DishExample.menu.stream()
                        .collect(Collectors.maxBy(dishCaloriesComparator));
    }
}
