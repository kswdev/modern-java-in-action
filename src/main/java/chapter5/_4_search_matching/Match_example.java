package chapter5._4_search_matching;

import common.dish.Dish;
import common.dish.DishExample;

public class Match_example {

    public static void main(String[] args) {

        //프레디케이트가 적어도 한 요소와 일치하는지 확인
        if (DishExample.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is somewhat vegetarian friendly!");
        }

        //프레디케이트가 모든 요소와 일치하는지 확인
        boolean isHealthy = DishExample.menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);

        //프레디케이트와 일치하는 요소가 없는지 확인
        boolean isHealthy2 = DishExample.menu.stream()
                .noneMatch(dish -> dish.getCalories() > 1000);
    }
}
