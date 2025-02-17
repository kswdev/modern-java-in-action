package chapter5._7_make_stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Make_stream_example {

    public static void main(String[] args) {

        //문자열
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");

        stream.map(String::toUpperCase).forEach(System.out::println);

        //배열 -> stream
        int[] numbers = {2, 3, 4, 5, 6};
        int sum = Arrays.stream(numbers).sum();

        //파일 -> stream
        try(Stream<String> lines
                = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {

            long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                                                                 .distinct()
                                                                 .count();

        } catch (IOException e) {
            //파일을 열다 발생한 오류
        }

        //무한 스트림 - iterate
        Stream.iterate(0, n -> n+2)
                .limit(10)
                .forEach(System.out::println);

        //100보다 작은 수 까지
        Stream.iterate(0, n -> n < 100,n -> n+2)
                .limit(5)
                .forEach(System.out::println);

        //무한 스트림 - generate
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
