package chapter13._4_interpret_rule.diamont;

public interface B extends A {
    default void hello() {
        System.out.println("Hello from B");
    }
}
