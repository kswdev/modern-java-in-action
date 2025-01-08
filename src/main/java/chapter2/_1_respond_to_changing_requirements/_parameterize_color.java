package chapter2._1_respond_to_changing_requirements;

import common.apple.Apple;
import common.apple.Color;

import java.util.ArrayList;
import java.util.List;

public class _parameterize_color {

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }
}
