package chapter16._3_non_blocking_code.common;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static chapter16.common.Util.delay;
import static chapter16.common.Util.random;

public class Shop {

    private String name;
    private double price;

    public Shop(String name) {
        this.name = name;
    }

    public Shop() {}

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay(1);
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public String getName() {
        return name;
    }
    public double getPrice(String product) {
        return calculatePrice(product);
    }
}
