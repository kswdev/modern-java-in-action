package chapter6._2_reducing_and_summation;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class SummingInt_example {

    public static void main(String[] args) {
        int totalCalories = DishExample.menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));

        int totalCalories2 = DishExample.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        double averageCalories = DishExample.menu.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));

        double averageCalories2 = DishExample.menu.stream()
                .mapToInt(Dish::getCalories)
                .average()
                .orElse(0);

        IntSummaryStatistics menuStatistics = DishExample.menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));

        System.out.println(menuStatistics);
    }
}
