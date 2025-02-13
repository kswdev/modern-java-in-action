package chapter5._2_stream_slicing;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.List;

public class DropWhile_example {

    public static void main(String[] args) {
        //요소가 칼로리 순으로 정렬되어 있다면 takeWhile을 이용해 320보다 큰 칼로리를 가진 요소만 반복 작업을 할 수 있다.
        List<Dish> slicedMenuWithDropWhile = DishExample.menu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .toList();
    }
}
