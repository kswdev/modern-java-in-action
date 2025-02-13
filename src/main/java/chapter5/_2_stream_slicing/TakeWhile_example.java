package chapter5._2_stream_slicing;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.List;

public class TakeWhile_example {

    public static void main(String[] args) {
        List<Dish> filteredMenu = DishExample.menu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .toList();

        //요소가 칼로리 순으로 정렬되어 있다면 takeWhile을 이용해 320보다 작은 칼로리를 가진 요소를 반복 작업을 중단할 수 있다.
        List<Dish> slicedMenuWithTakeWhile = DishExample.menu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .toList();
    }

}
