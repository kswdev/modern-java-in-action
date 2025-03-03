package chapter7._3_spliterator.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        //현재 문자를 소비
        action.accept(string.charAt(currentChar++));
        //소비할 문자가 남아있으면 true 를 반환한다.
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
            return null;
        }

        for (int splitPos = currentSize / 2 + currentChar;
                //파싱할 문자열의 중간을 분할 위치로 설정
                splitPos < string.length(); splitPos++) {
            //다음 공백이 나올 때까지 분할 위치를 뒤로 이동
            if (Character.isWhitespace(string.charAt(splitPos))) {
                Spliterator<Character> spliterator =
                        new WordCounterSpliterator(string.substring(currentChar, splitPos));
                //시작 위치를 분할 위치로 설정
                currentChar = splitPos;
                return spliterator;
            }
        }

        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}