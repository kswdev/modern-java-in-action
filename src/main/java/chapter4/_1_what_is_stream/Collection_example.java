package chapter4._1_what_is_stream;

import chapter4.common.Dish;
import chapter4.common.DishExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collection_example {

    public static void main(String[] args) {

        List<Dish> lowCaloricDishes = new ArrayList<>();

        //누적자로 요소 필터링
        for (Dish dish : DishExample.menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        //익명 클래스로 요리 정렬
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();

        //정렬된 리스트를 처리하면서 요리 이름 선택
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
    }
}
