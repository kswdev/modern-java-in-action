package chapter5._3_mapping;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.List;

public class MethodReference_example {

    public static void main(String[] args) {

        //메서드 참조를 통해 요리 이름을 추출해 리스트로 만들기
        List<String> dishNames = DishExample.menu.stream()
                .map(Dish::getName)
                .toList();

        //메서드 참조를 통해 요리 이름을 추출 후 이름 길이를 구해 리스트로 만들기
        List<Integer> dishNamesLength = DishExample.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .toList();
    }
}
