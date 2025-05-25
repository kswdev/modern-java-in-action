package chapter15._2_sync_async.reactive;

import java.util.function.IntConsumer;

public class RockExample {

    public static void main(String[] args) {
        int x = 1337;
        Result result = new Result();
        Object lock = new Object();
        boolean[] completed = new boolean[2];

        f(x, (int y) -> {
            synchronized (lock) {
                result.left = y;
                completed[0] = true;
                if (completed[0] && completed[1]) {
                    System.out.println(result.left + result.right);
                }
            }
        });

        g(x, (int z) -> {
            synchronized (lock) {
                result.right = z;
                completed[1] = true;
                if (completed[0] && completed[1]) {
                    System.out.println(result.left + result.right);
                }
            }
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

    private static class Result {
        private int right;
        private int left;
    }
}
