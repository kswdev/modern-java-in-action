package chapter9._1_refactoring;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.ArrayList;
import java.util.List;

public class Stream_example {

    public static void main(String[] args) {
        List<Dish> dishes = DishExample.menu;
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                dishNames.add(dish.getName());
            }
        }

        // 병렬성, 가독성 상승
        dishes.parallelStream()
                .filter(dish -> dish.getCalories() < 400)
                .map(Dish::getName)
                .toList();
    }
}
