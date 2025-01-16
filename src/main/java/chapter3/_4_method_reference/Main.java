package chapter3._4_method_reference;

import common.apple.Apple;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {

    private static List<Apple> inventory = new ArrayList<>();

    public static void main(String[] args) {
        inventory.sort((Apple a1, Apple a2) ->
                a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort(comparing(Apple::getWeight));


    }
}
