package chapter7._2_fork_join_framework.forkJoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    //더할 숫자 배열
    private final long[] numbers;
    //이 서브태스크에서 처리할 배열의 초기 위치와 최종 위치
    private final int start;
    private final int end;
    //분리할 수 없는 서브태스크의 기준
    private static final long THRESHOLD = 10_000;


    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0,  numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinSumCalculator left =
                new ForkJoinSumCalculator(numbers, start, start + length / 2);
        //ForkJoinPool 의 다른 스레드로 새로 생성한 태스크를 비동기 실행
        left.fork();
        ForkJoinSumCalculator right = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        //두 번째 서브태스크를 동기 실행
        Long rightResult = right.compute();
        Long leftResult = left.join();
        return leftResult + rightResult;
    }

    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}