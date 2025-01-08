package chapter2._3_simplize;

import common.apple.Apple;
import common.apple.Color;

import java.util.ArrayList;
import java.util.List;

import static chapter2._3_simplize.filter._list_abstract.*;

public class _list {

    private static List<Apple> inventory = new ArrayList<>();
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        List<Apple> redApples =
                filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));

        List<Integer> evenNumners =
                filter(numbers, (Integer i) -> i % 2 == 0);
    }
}
