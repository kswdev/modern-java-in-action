package chapter15._2_sync_async.reactive;

import java.util.function.IntConsumer;

public class CallbackStyleExample {

    /*
     *  f 와 g 의 호출 합계를 정확하게 출력하지 않고 상황에 따라 먼저 계산된 결과를 출력한다.
     *  락을 사용하지 않으므로 값을 두 번 출력할 수 있을 뿐더러
     *  때로는 +에 제공된 두 피연산자가 println 호출되기 전에 업데이트 될 수 있다.
     *  아래처럼 두 가지 방법으로 이 문제를 보완할 수 있다.
     */
    public static void main(String[] args) {

        int x = 1337;
        Result result = new Result();

        f(x, (int y) -> {
            result.left = y;
            System.out.println(result.left + result.right);
        });

        g(x, (int z) -> {
            result.right = z;
            System.out.println(result.left + result.right);
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
