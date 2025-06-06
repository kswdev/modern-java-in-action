package chapter19._1_curring;

import java.util.function.DoubleUnaryOperator;

import static chapter19._1_curring.CurringFactory.*;

public class Main {

    public static void main(String[] args) {
        DoubleUnaryOperator converterCtoF = curriedConverter(9.0/5, 32);
        DoubleUnaryOperator converterUSDtoGBP = curriedConverter(0.6, 0);
        DoubleUnaryOperator converterKmtoMi = curriedConverter(0.6214, 0);

        double gpb = converterCtoF.applyAsDouble(1000);
    }
}
