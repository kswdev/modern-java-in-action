package chapter16._2_async_api.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static chapter16._2_async_api.common.Util.delay;
import static chapter16._2_async_api.common.Util.random;

public class Shop {
    public Future<Double> getPriceAsync(String product) {
        // 계산 결과를 포함할 Future 객체를 생성하고 비동기적으로 계산을 수행
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                // 다른 스레드에서 비동기적으로 계산을 수행
                double price = calculatePrice(product);
                // 계산이 끝나면 결과를 Future에 담아줌
                futurePrice.complete(price);
            } catch (Exception e) {
                // 도중에 문제가 발생하면 에러를 포함시켜 Future를 종료한다.
                futurePrice.completeExceptionally(e);
            }
        }).start();
        // 결과를 기다리지 않고 Future 객체를 반환
        return futurePrice;
    }

    private double calculatePrice(String product) {
        delay(1);
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
