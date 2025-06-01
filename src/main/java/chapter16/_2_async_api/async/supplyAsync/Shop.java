package chapter16._2_async_api.async.supplyAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static chapter16.common.Util.delay;
import static chapter16.common.Util.random;

public class Shop {
    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay(1);
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
