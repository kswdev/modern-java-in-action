package chapter4._2_stream_operation;

import common.dish.DishExample;

import java.util.List;

public class Intermediate_example {

    public static void main(String[] args) {

        List<String> names = DishExample.menu.stream()
                .filter(dish -> {
                    System.out.println("filter: " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("map: " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .toList();

        System.out.println(names);
    }
}
