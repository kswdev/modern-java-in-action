package chapter6._1_reducing_and_summation;

import common.dish.DishExample;

import java.util.stream.Collectors;

public class Count_example {

    public static void main(String[] args) {
        long howManyDishes = DishExample.menu.stream()
                .collect(Collectors.counting());
    }
}
