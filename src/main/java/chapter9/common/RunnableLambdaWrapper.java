package chapter9.common;

public class RunnableLambdaWrapper {
    private final Runnable runnable = () -> System.out.println(this);

    public Runnable getRunnable() {
        return runnable;
    }

    @Override
    public String toString() {
        return "RunnableLambdaWrapper{" + "LambdaWrapper" + "}";
    }
}
