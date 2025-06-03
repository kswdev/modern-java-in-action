package chapter16._5_react_end_of_completableFuture;

import java.util.concurrent.CompletableFuture;

import static chapter16._5_react_end_of_completableFuture.domain.shop.Shops.findPricesAsync;

public class Main {

    public static void main(String[] args) {
        CompletableFuture[] futures = findPricesAsync("myPhone")
                .map(f -> f.thenAccept(System.out::println))
                .toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(futures).join();
    }
}
