package chapter5._4_search_matching;

import common.dish.Dish;
import common.dish.DishExample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Search_example {

    public static void main(String[] args) {
        Optional<Dish> dish =
                DishExample.menu.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();

        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(n -> n * n)
                        .filter(n -> n % 3 == 0)
                        .findFirst();
    }
}
