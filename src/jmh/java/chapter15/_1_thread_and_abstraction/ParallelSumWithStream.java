package chapter15._1_thread_and_abstraction;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime) //벤치마크 대상 메서드를 실행하는 데 걸링 평균 시간 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS) //벤치마크 결과를 밀리초 단위로 출력
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"}) //4Gb의 힙 공간을 제공한 환경에서 두 번 벤치마크를 수행
@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 5, time = 1)
public class ParallelSumWithStream {

    private static final long N = 1_000_000L;
    private int[] stats;

    @Setup
    public void setup() {
        stats = new int[1000000000];
        Arrays.parallelSetAll(stats, i -> ThreadLocalRandom.current().nextInt(100));
    }

    @Benchmark
    public long parallelSumWithStream() {
        return Arrays.stream(stats)
                .parallel()
                .sum();
    }

    @TearDown(Level.Invocation) // 매 번 벤치마크 실행한 다음에는 가비지 컬렉터 동작 시도
    public void tearDown() {
        System.gc();
    }
}
