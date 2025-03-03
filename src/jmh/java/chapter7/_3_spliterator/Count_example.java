package chapter7._3_spliterator;

import chapter7._3_spliterator.counter.WordCounter;
import chapter7._3_spliterator.spliterator.WordCounterSpliterator;

import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static chapter7._3_spliterator.counter.LoopCounter.countWordsIteratively;

public class Count_example {

    public static void main(String[] args) {
        String sentence = "DS RHeLLO World  rice          shrimp bookmark";

        //반복문을 사용
        System.out.println(countWordsIteratively(sentence));


        //스트림을 사용
        Stream<Character> stream = IntStream.range(0, sentence.length())
                                            .mapToObj(sentence::charAt);

        System.out.println(countWords(stream));;
        System.out.println(countWords(stream.parallel()));

        Spliterator<Character> spliterator = new WordCounterSpliterator(sentence);
        Stream<Character> streamWithSpliterator = StreamSupport.stream(spliterator, true);

        System.out.println(countWords(streamWithSpliterator));
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter reduce = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);

        return reduce.getCounter();
    }


}
