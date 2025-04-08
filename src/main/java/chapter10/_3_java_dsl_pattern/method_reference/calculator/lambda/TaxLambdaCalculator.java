package chapter10._3_java_dsl_pattern.method_reference.calculator.lambda;

import chapter10._3_java_dsl_pattern.model.Order;

import java.util.function.DoubleUnaryOperator;

public class TaxLambdaCalculator {

    // 주문값에 적용된 모든 세금을 계산하는 함수
    public DoubleUnaryOperator taxFunction = price -> price;

    public TaxLambdaCalculator with(DoubleUnaryOperator operator) {
        // 새로운 세금 계산 함수를 얻어서 인수로 전달된 함수와 현재 함수를 합침
        taxFunction = taxFunction.andThen(operator);
        return this;
    }

    public double calculate(Order order) {
        // 주문의 총 합에 세금 계산 함수를 적용해 최종 주문값을 계산
        return taxFunction.applyAsDouble(order.getValue());
    }
}