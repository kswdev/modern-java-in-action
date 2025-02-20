package chapter6._2_reducing_and_summation;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.stream.Collectors;

public class PliabilityOfCollection_example {

    public static void main(String[] args) {
        int totalCalories = DishExample.menu.stream()
                .collect(Collectors.reducing(0,                 //초깃값
                                                    Dish::getCalories,  //변환 함수
                                                    Integer::sum));     //합계 함수
    }
}
