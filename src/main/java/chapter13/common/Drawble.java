package chapter13.common;

public interface Drawble {

    default void draw() {
        throw new UnsupportedOperationException();
    }
}
