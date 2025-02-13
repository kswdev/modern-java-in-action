package chapter5._1_filtering;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.List;

public class Predicate_example {

    public static void main(String[] args) {
        List<Dish> vegetarianMenu = DishExample.menu.stream()
                .filter(Dish::isVegetarian)
                .toList();
    }
}
