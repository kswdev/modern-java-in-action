package chapter16._1_simple_Future;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            public Double call() {
                return doSomeLongComputation();
            }
        });

        doSomethingElse();

        try {
            // get 메서드를 호출했을 때 이미 계산이 완료되어 결과가 준비되었다면 즉시 결과를 반환하지만
            // 결과가 준비되지 않았다면 작업이 완료될 때까지 스레드를 블록시킨다.
            // 따라서 타임아웃을 설정해주는 것이 좋다.
            System.out.println("Result: " + future.get(1, TimeUnit.SECONDS));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void doSomethingElse() {
        try {
            Thread.sleep(500);
            System.out.println("Done!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Double doSomeLongComputation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1.0;
    }
}
