package chapter5._6_number_stream;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.OptionalInt;

public class NumberStream_example {

    public static void main(String[] args) {

        //평범한 map
        int caloriesWithMap = DishExample.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        //mapToInt
        int caloriesWithMapToInt = DishExample.menu.stream()
                .mapToInt(Dish::getCalories)
                .reduce(0, Integer::sum);

        OptionalInt maxCalories = DishExample.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max = maxCalories.orElse(0);
    }
}
