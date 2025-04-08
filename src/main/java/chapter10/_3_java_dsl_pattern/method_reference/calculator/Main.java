package chapter10._3_java_dsl_pattern.method_reference.calculator;

import chapter10._3_java_dsl_pattern.method_reference.calculator.classic.TaxClassicCalculator;
import chapter10._3_java_dsl_pattern.method_reference.calculator.lambda.TaxLambdaCalculator;
import chapter10._3_java_dsl_pattern.model.Order;
import chapter10._3_java_dsl_pattern.model.Tax;

import static chapter10._3_java_dsl_pattern.combination.builder.MixedBuilder.*;
import static chapter10._3_java_dsl_pattern.model.Tax.calculate;

public class Main {

    public static void main(String[] args) {
        Order order =
                forCustomer("BigBank",
                        buy(t -> t.quantity(80)
                                .stock("IBM")
                                .on("NYSE")
                                .at(125.00)),
                        sell(t -> t.quantity(50)
                                .stock("GOOGLE")
                                .on("NASDAQ")
                                .at(375.00)));

        // 가장 간단하지만 가독성이 좋지 못한 세금 계산하는 코드
        double value = calculate(order, true, false, true);

        // 가독성은 좋지만 장환한 세금 계산하는 코드
        double value2 = new TaxClassicCalculator().withTaxRegional()
                                                  .withTaxSurcharge()
                                                  .calculate(order);

        // 가독성도 좋고 유연한 세금 계산 코드
        double value3 = new TaxLambdaCalculator().with(Tax::regional)
                                                 .with(Tax::surcharge)
                                                 .calculate(order);
    }
}
