package chapter11._3_optional_example;

import java.util.Optional;

public class Exception_optional {

    public static void main(String[] args) {

    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
