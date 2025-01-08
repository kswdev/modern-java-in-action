package chapter2._3_simplize;

import common.apple.Apple;
import common.apple.Color;

import java.util.ArrayList;
import java.util.List;

import static chapter2._2_behavior_parameterization.filter._filtering_abstract.filterApples;

public class _lamda {

    private static List<Apple> inventory = new ArrayList<>();

    public static void main(String[] args) {
        List<Apple> redApples = filterApples(inventory, apple -> Color.RED.equals(apple.getColor()));
    }
}
