package chapter16._2_async_api.sync;

import static chapter16.common.Util.delay;
import static chapter16.common.Util.random;

public class Shop {
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay(1000);
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
