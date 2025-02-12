package chapter4._1_what_is_stream;

import chapter4.common.Dish;
import chapter4.common.DishExample;

import java.util.Comparator;
import java.util.List;

public class Stream_example {

    public static void main(String[] args) {
        List<String> lowCaloricDishesName = DishExample.menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .toList();
    }
}
