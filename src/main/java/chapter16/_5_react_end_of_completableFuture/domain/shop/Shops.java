package chapter16._5_react_end_of_completableFuture.domain.shop;

import chapter16._5_react_end_of_completableFuture.domain.discount.Discount;
import chapter16._5_react_end_of_completableFuture.domain.discount.Quote;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static chapter16.common.Util.delay;

public abstract class Shops {

    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                  new Shop("LetsSaveBig"),
                                                  new Shop("BuyItAll"),
                                                  new Shop("ShopEasy"),
                                                  new Shop("MyFavoriteShop"));

    public static Stream<CompletableFuture<String>> findPricesAsync(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }
}
