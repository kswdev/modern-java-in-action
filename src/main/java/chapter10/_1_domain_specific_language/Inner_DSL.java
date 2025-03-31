package chapter10._1_domain_specific_language;

import java.util.List;
import java.util.function.Consumer;

public class Inner_DSL {

    public static void main(String[] args) {

        List<String> numbers = List.of("one", "two", "three", "four");
        numbers.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        numbers.forEach(System.out::println);
    }
}
