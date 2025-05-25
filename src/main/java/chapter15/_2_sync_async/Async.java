package chapter15._2_sync_async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Async {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);

    protected static Future<Integer> f(int x) {
        return executorService.submit(() -> x+1);
    }

    protected static Future<Integer> g(int x) {
        return executorService.submit(() -> x*2);
    }
}
