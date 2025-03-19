package chapter9._2_refactoring_designPattern.strategy;

@FunctionalInterface
public interface ValidationStrategy {
    boolean execute(String s);
}
