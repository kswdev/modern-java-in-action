package chapter6._3_grouping;

import common.dish.CaloricLevel;
import common.dish.Dish;
import common.dish.DishExample;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Group_example {

    public static void main(String[] args) {
        //List<Dish> -> Map<Dish.Type, List<Dish>>
        Map<Dish.Type, List<Dish>> dishesByType = DishExample.menu.stream()
                .collect(groupingBy(Dish::getType));


        // 400칼로리 이하을 'diet',
        // 400~700칼로리를 'normal',
        // 700칼로리 초과를 'fat'
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = DishExample.menu.stream().collect(
                groupingBy((dish) ->{
                    if (dish.getCalories() < 400){
                        return CaloricLevel.DIET;
                    } else if (400 < dish.getCalories() && dish.getCalories() < 700){
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                })
        );

        //그룹화 전에 500칼로리가 넘는 요리만 필터링하기
        //단점 : 해당하는 요소가 없는 FISH 키 값은 존재하지 않는다.
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                DishExample.menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .collect(groupingBy(Dish::getType));

        //위 문제 해결
        Map<Dish.Type, List<Dish>> caloricDishesByType2 =
                DishExample.menu.stream()
                        .collect(groupingBy(Dish::getType,
                                 filtering(dish -> dish.getCalories() > 300,
                                 toList())));

        //값을 문자열 리스트로 받기
        Map<Dish.Type, List<String>> dishNamesByType =
                DishExample.menu.stream()
                        .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        //다수준 그룹화
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                DishExample.menu.stream()
                        .collect(groupingBy(Dish::getType, groupingBy(dish -> {
                            if (dish.getCalories() < 300) return CaloricLevel.DIET;
                            else if (700 < dish.getCalories()) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })));

        System.out.println(dishesByTypeCaloricLevel);
    }
}
