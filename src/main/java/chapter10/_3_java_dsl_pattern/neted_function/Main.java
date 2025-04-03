package chapter10._3_java_dsl_pattern.neted_function;

import chapter10._3_java_dsl_pattern.model.Order;

import static chapter10._3_java_dsl_pattern.neted_function.builder.NestedFunctionOrderBuilder.*;

public class Main {

    public static void main(String[] args) {
        Order order = order("BigBlank",
                            buy(80,
                                        stock("IBM", on("NYSE")), at(125.00)),
                            sell(50,
                                   stock("GOOGLE", on("NASDAQ")), at(375.00))
                            );
    }
}