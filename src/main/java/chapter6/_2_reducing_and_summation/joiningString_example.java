package chapter6._2_reducing_and_summation;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.stream.Collectors;

public class joiningString_example {

    public static void main(String[] args) {
        String shortMenu = DishExample.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining());

        String shortMenu2 = DishExample.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));

        System.out.println(shortMenu2);
    }
}
