package chapter2.respond_to_changing_requirements;

import chapter2.common.Apple;
import chapter2.common.Color;

import java.util.ArrayList;
import java.util.List;

public class _filtering_green_apple {

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }
}
