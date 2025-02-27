package chapter7._1_parallel_stream;

import java.util.stream.Stream;

public class parallelStream_example {

    public static void main(String[] args) {

    }

    //parallel 을 호출해 병렬로 수정
    public long sequentialParallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    //순차 스트림
    public long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    //전통적인 반복문
    public long iterativeSum(long n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
