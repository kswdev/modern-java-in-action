package chapter10._3_java_dsl_pattern.method_chain.builder;

import chapter10._3_java_dsl_pattern.model.Trade;

public class TradeBuilder {

    private final MethodChainingOrderBuilder builder;
    public final Trade trade = new Trade();

    protected TradeBuilder(
            MethodChainingOrderBuilder builder,
            Trade.Type type, int quantity
    ) {
        this.builder = builder;
        trade.setType(type);
        trade.setQuantity(quantity);
    }

    public StockBuilder stock(String symbol) {
        return new StockBuilder(builder, trade, symbol);
    }
}