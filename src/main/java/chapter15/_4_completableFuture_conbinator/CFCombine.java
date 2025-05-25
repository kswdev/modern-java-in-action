package chapter15._4_completableFuture_conbinator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFCombine {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        int x = 1337;

        CompletableFuture<Integer> a = new CompletableFuture<>();
        CompletableFuture<Integer> b = new CompletableFuture<>();
        CompletableFuture<Integer> c = a.thenCombine(b, (x1, x2) -> x1 + x2);

        service.submit(() -> a.complete(f(x)));
        service.submit(() -> b.complete(g(x)));

        System.out.println(c.get());

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
