package chapter10._3_java_dsl_pattern.method_chain.builder;

import chapter10._3_java_dsl_pattern.model.Trade;

public class TradeBuilderWithStock {

    private final MethodChainingOrderBuilder builder;
    private final Trade trade;

    protected TradeBuilderWithStock(
            MethodChainingOrderBuilder builder,
            Trade trade
    ) {
        this.builder = builder;
        this.trade = trade;
    }

    public MethodChainingOrderBuilder at(double price) {
        trade.setPrice(price);
        return builder.addTrade(trade);
    }
}