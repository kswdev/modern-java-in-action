package chapter15._2_sync_async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static chapter15._2_sync_async.Async.*;

public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Integer> f = f(1337);
        Future<Integer> g = g(1337);

        System.out.println(f.get() + g.get());
    }
}
