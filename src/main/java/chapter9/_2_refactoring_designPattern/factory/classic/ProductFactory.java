package chapter9._2_refactoring_designPattern.factory.classic;

import chapter9._2_refactoring_designPattern.factory.common.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {
    public static Product createProduct(String name) {
        return switch (name) {
            case "loan" -> new Loan();
            case "bond" -> new Bond();
            case "stock" -> new Stock();
            default -> throw new RuntimeException("No such product: " + name);
        };
    }

    final static Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("bond", Bond::new);
        map.put("stock", Stock::new);
    }

    public static Product createProduct2(String name) {
        Supplier<Product> supplier = map.get(name);
        if (supplier != null) return supplier.get();
        throw new IllegalArgumentException("No such product: " + name);
    }

    //인수를 세가지 받는 상품일 경우
    final static Map<String, TriFunction<Integer, Integer, String, Product>> map2 = new HashMap<>();
}
