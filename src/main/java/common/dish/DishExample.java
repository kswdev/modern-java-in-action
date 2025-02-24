package common.dish;

import java.util.Arrays;
import java.util.List;

public abstract class DishExample {
    public static List<Dish> menu = Arrays.asList(
            new Dish("season fruits", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("salmon", false, 250, Dish.Type.FISH),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("pork", false, 800, Dish.Type.MEAT)
    );
}
