package chapter16._4_async_pipeline.domain.shop;

import chapter16._4_async_pipeline.domain.discount.Discount;
import chapter16._4_async_pipeline.domain.discount.Quote;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static chapter16.common.Util.delay;

public abstract class Shops {

    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                  new Shop("LetsSaveBig"),
                                                  new Shop("BuyItAll"),
                                                  new Shop("ShopEasy"),
                                                  new Shop("MyFavoriteShop"));

    // 순차 스트림
    public static List<String> findPrices(String product) {
        return shops.stream()
                // 각 상점에서 할인전 가격 얻기
                .map(shop -> shop.getPrice(product))
                // 상점에서 반환한 문자열을 Quote 객체로 파싱
                .map(Quote::parse)
                // Discount 서비스를 이용해서 각 Quote 에 할인을 적용
                .map(Discount::applyDiscount)
                .toList();
    }

    // 동기 + 비동기
    public static List<String> asyncAndSyncFindPrices(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                     .map(shop -> CompletableFuture.supplyAsync(
                             () -> shop.getPrice(product), executor))
                     .map(future -> future.thenApply(Quote::parse))
                     .map(future -> future.thenCompose(quote ->
                             CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote))))
                     .toList();

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .toList();
    }

    // 독립적인 두 개의 CompletableFuture 합치기
     public static double futurePriceInUSD(String product) {
         Shop shop = new Shop(product);
         CompletableFuture<Double> futurePrice =
                 CompletableFuture
                         .supplyAsync(() -> shop.getPrice(product))
                         .thenApply(Quote::parse)
                         .thenApply(Quote::getPrice)
                         .thenCombine(
                                 CompletableFuture.supplyAsync(
                                         () -> getRate("EUR", "USD"))
                                         // 디폴트 값, 시간, 시간 단위
                                         .completeOnTimeout(1.1, 2, TimeUnit.SECONDS),
                                 (price, rate) -> price * rate
                         ).orTimeout(3, TimeUnit.SECONDS);

         return futurePrice.join();
     }

     private static double getRate(String from, String to) {
        delay(1);
        return 1.1;
     }
}
