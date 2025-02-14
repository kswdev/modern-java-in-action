package chapter5._3_mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flatten_example {

    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "World");

        /*
        아래는 Stream<String[]> 를 리스트로 반환하는 잘못된 코드이다.

        List<String> flattenStrings = strings.stream()
                .map(s -> s.split(""))
                .distinct()
                .toList();
         */

        //map과 Arrays.stream 활용
        String[] arrayOfWords = {"Hello", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        //결국 Stream<Stream<String>> 이 만들어지기 때문에 문제가 해결되지 않는다.
        strings.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .forEach(System.out::println);

        //flatMap 사용
        List<String> uniqueCharacters = strings.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();


        //두 리스트를 반복해 숫자쌍을 만드는 예제
        List<Integer> numbers1 = List.of(1, 2, 3);
        List<Integer> numbers2 = List.of(4, 5);

        List<Integer[]> list = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new Integer[]{i, j}))
                .toList();
    }
}
