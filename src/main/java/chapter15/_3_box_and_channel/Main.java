package chapter15._3_box_and_channel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private final static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 겉보기엔 깔끔해 보이는 코드지만 자바가 q1, q2를 차례로 호출하는데 이는 하드웨어 병렬성을 활용하지 않는다.
        int x = 10;
        int t = p(x);

        System.out.println(r(q1(t), q2(t)));

        // Future를 이용해 q1, q2 를 병렬로 평가해보자
        // 이 예제에서는 박스와 채널 다이어그램의 모양상 p와 r을 Future로 감싸지 않았다.
        // p는 다른 어떤 작업보다 먼저 처리해야 하며 r은 모든 작업이 끝난 다음 가장 마지막으로 처리해야 한다.
        Future<Integer> a1 = executor.submit(() -> q1(t));
        Future<Integer> a2 = executor.submit(() -> q2(t));
        System.out.println(r(a1.get(), a2.get()));
    }

    private static int p(int x) {
        return x * 10;
    }

    private static int q1(int x) throws InterruptedException {
        Thread.sleep(1000);
        return x + 1;
    }

    private static int q2(int x) throws InterruptedException {
        Thread.sleep(1000);
        return x + 2;
    }

    private static int r(int x, int y) {
        return x + y;
    }
}
