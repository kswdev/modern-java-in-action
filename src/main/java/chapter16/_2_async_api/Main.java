package chapter16._2_async_api;

import chapter16._2_async_api.async.Shop;

import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();
        long start = System.currentTimeMillis();
        Future<Double> futurePrice = shop.getPriceAsync("product");
        long invocationTime = System.currentTimeMillis() - start;

        System.out.println("Invocation returned after " + invocationTime + " ms");

        // 제품의 가격을 계산하는 동안
        doSomethingElse();

        try {
            double price = futurePrice.get();
            System.out.println("Price is " + price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis() - start;
        System.out.println("Price returned after " + end + " ms");
    }

    private static void doSomethingElse() {
        System.out.println("do something else");
    }
}
