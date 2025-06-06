package chapter7._1_parallel_stream;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime) //벤치마크 대상 메서드를 실행하는 데 걸링 평균 시간 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS) //벤치마크 결과를 밀리초 단위로 출력
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"}) //4Gb의 힙 공간을 제공한 환경에서 두 번 벤치마크를 수행
@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 5, time = 1)
public class ParallelStreamBenchmark {

    private static final long N = 10_000_000L;

    //병렬 스트림, 오토박싱 언박싱, 청크 분할 x
    //@Benchmark
    public long sequentialSum() {
        return Stream.iterate(1L, i->i+1).limit(N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    //병렬 스트림 오토박싱, 언박싱 x 청크 분할 o
    @Benchmark
    public long sequentialSumWithLongStream() {
        return LongStream.rangeClosed(0L, N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    @TearDown(Level.Invocation) // 매 번 벤치마크 실행한 다음에는 가비지 컬렉터 동작 시도
    public void tearDown() {
        System.gc();
    }
}
