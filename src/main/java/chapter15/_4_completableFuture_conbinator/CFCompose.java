package chapter15._4_completableFuture_conbinator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFCompose {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        int x = 1337;
        CompletableFuture<Integer> a = new CompletableFuture<>();
        service.submit(() -> a.complete(f(x)));
        int b = g(x);

        System.out.println(a.get() + b);

        service.shutdown();
    }

    private static int f(int x) throws InterruptedException {
        Thread.sleep(1000);
        return x+1;
    }

    private static int g(int x) throws InterruptedException {
        Thread.sleep(1000);
        return x*2;
    }
}
