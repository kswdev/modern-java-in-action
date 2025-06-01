package chapter16._3_non_blocking_code.common;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Shops {

    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    private static final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                  new Shop("LetsSaveBig"),
                                                  new Shop("BuyItAll"),
                                                  new Shop("BuyItAll2"),
                                                  new Shop("MyFavoriteShop"));

    // 순차 스트림
    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .toList();
    }

    // 병렬 스트림
    public static List<String> parallelFindPrices(String product) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");

        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .toList();
    }

    // 비동기 호출
    public static List<String> asyncFindPricesAsync(String product) {

        List<CompletableFuture<String>> priceFutures = shops.stream()
                // CompletableFuture로 각각의 가격을 비동기적으로 계산한다.
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f",
                                shop.getName(), shop.getPrice(product)), executor)
                ).toList();

        return priceFutures.stream()
                // 모든 비동기 동작이 끝나길 기다린다.
                .map(CompletableFuture::join)
                .toList();
    }
}
