package chapter9._2_refactoring_designPattern.factory.common;

public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
