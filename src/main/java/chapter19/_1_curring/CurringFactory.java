package chapter19._1_curring;

import java.util.function.DoubleUnaryOperator;

public abstract class CurringFactory {

    public static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }
}
