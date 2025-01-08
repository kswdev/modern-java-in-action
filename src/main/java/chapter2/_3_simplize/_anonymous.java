package chapter2._3_simplize;

import chapter2._2_behavior_parameterization.predicate.ApplePredicate;
import common.apple.Apple;
import common.apple.Color;

import java.util.ArrayList;
import java.util.List;

import static chapter2._2_behavior_parameterization.filter._filtering_abstract.filterApples;

public class _anonymous {

    private static List<Apple> inventory = new ArrayList<>();

    public static void main(String[] args) {
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });
    }
}
