package chapter10._2_java8_smallest_DSL;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.*;

public class Comparator {

    public static void main(String[] args) {
        List<Dish> dishes = DishExample.menu;

        Collections.sort(dishes, new java.util.Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories() - o2.getCalories();
            }
        });

        Collections.sort(dishes, (o1, o2) -> o1.getCalories() - o2.getCalories());

        // 람다 표현식
        Collections.sort(dishes, comparing(o1 -> o1.getCalories()));

        // 메서드 참조
        Collections.sort(dishes, comparing(Dish::getCalories));

        // 역순 정렬
        Collections.sort(dishes, comparing(Dish::getCalories).reversed());

        // 같은 나이일 경우 이름 비교
        Collections.sort(dishes, comparing(Dish::getCalories)
                                    .thenComparing(Dish::getName));

        // List 인터페이스 추가된 새 sort 메서드를 이용해 코드를 깔끔하게 정리할 수 있다.
        dishes.sort(comparing(Dish::getCalories)
                    .thenComparing(Dish::getName));
    }
}
