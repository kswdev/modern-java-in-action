package chapter15._2_sync_async.reactive;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntConsumer;

public class CompletableFutureExample {

    public static void main(String[] args) {
        int x = 1337;
        CompletableFuture<Integer> future1 = new CompletableFuture<>();
        CompletableFuture<Integer> future2 = new CompletableFuture<>();

        f(x, future1::complete);
        g(x, future2::complete);

        future1.thenCombine(future2, (y, z) -> {
            System.out.println(y + z);
            return y + z;
        });

    }

    private static void g(int x, IntConsumer consumer) {
        x *= 2;
        consumer.accept(x);
    }

    private static void f(int x, IntConsumer consumer) {
        x += 1;
        consumer.accept(x);
    }
}
