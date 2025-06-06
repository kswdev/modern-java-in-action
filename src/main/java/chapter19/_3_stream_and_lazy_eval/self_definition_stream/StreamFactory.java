package chapter19._3_stream_and_lazy_eval.self_definition_stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class StreamFactory {

    // 획득한 머리로 숫자를 필터링
    public static void main(String[] args) {
        IntStream numbers = numbers();
        IntStream primes = primes(numbers);

        primes.limit(10)
              .forEach(System.out::println);
    }

    // 스트림 재귀를 이용하는 소수 찾기 알고리즘
    // 4단계 : 재귀

    /**
     * 안타깝게도 4 단계 코드를 실행하면 stream has already been operated upon or closed 라는 에러가 발생한다.
     * 사실 우리는 스트림을 머리와 꼬리로 분리하는 두 개의 최종 연산 findFirst와 skip을 사용했다.
     * 스트림에서 최종 연산을 스트림에 호출하면 스트림이 완전히 소비된다.
     */
    public static IntStream primes(IntStream numbers) {
        int head = head(numbers);
        return IntStream.concat(
                IntStream.of(head),
                primes(tail(numbers).filter(n -> n % head != 0))
        );
    }

    // 스트림 재귀를 이용하는 소수 찾기 알고리즘
    // 3단계 : 꼬리 필터링
    public static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

    // 스트림 재귀를 이용하는 소수 찾기 알고리즘
    // 2단계 : 머리 획득
    public static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }


    // 스트림 재귀를 이용하는 소수 찾기 알고리즘
    // 1단계 : 스트림 숫자 얻기
    public static IntStream numbers() {
        return IntStream.iterate(2, n -> n + 1);
    }

    // 스트림을 이용한 소수 찾기 알괼즘
    public static Stream<Integer> primes(int n) {
        return Stream.iterate(2, i -> i + 1)
                     .filter(StreamFactory::isPrime)
                     .limit(n);
    }

    public static boolean isPrime(int n) {
        int candidateRoot = (int) Math.sqrt(n);
        return IntStream.rangeClosed(2, candidateRoot)
                        .noneMatch(i -> n % i == 0);
    }
}
