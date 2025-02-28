package chapter7._1_parallel_stream;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime) //벤치마크 대상 메서드를 실행하는 데 걸링 평균 시간 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS) //벤치마크 결과를 밀리초 단위로 출력
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"}) //4Gb의 힙 공간을 제공한 환경에서 두 번 벤치마크를 수행
@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 5, time = 1)
public class SequentialForBenchmark {

    private static final long N = 10_000_000L;

    @Benchmark
    public long sequentialSum() {
        long sum = 0;

        for (long i = 1L; i <= N; i++)
            sum += i;

        return sum;
    }

    @TearDown(Level.Invocation) // 매 번 벤치마크 실행한 다음에는 가비지 컬렉터 동작 시도
    public void tearDown() {
        System.gc();
    }
}
