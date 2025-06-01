package chapter16._2_async_api.sync;

public class Shop {
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay(1000);
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
