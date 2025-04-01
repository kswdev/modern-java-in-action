package chapter10._3_java_dsl_pattern.method_chain;

import chapter10._3_java_dsl_pattern.model.Order;

import static chapter10._3_java_dsl_pattern.method_chain.builder.MethodChainingOrderBuilder.forCustomer;

public class Main {

    public static void main(String[] args) {
        Order order = forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(375.00)
                .end();
    }
}
