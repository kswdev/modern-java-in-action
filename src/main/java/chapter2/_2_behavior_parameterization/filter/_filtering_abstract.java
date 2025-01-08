package chapter2._2_behavior_parameterization.filter;

import chapter2._2_behavior_parameterization.predicate.ApplePredicate;
import chapter2.common.Apple;

import java.util.ArrayList;
import java.util.List;

public class _filtering_abstract {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (p.test(apple)) { //프레디케이트 객체로 사과 검사 조건을 캡슣화했다.
                result.add(apple);
            }
        }

        return result;
    }
}
