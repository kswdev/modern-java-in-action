package chapter5._2_stream_slicing;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.List;

public class Limit_example {

    public static void main(String[] args) {
        List<Dish> dishes = DishExample.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .toList();
    }
}