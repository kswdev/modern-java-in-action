package chapter5._2_stream_slicing;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.List;

public class Skip_example {

    public static void main(String[] args) {
        //스트림의 처음 n개 요소를 제외한 스트림을 반환
        List<Dish> dishes = DishExample.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .toList();
    }
}
