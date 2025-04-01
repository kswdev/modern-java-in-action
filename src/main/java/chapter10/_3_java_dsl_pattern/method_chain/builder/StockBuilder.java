package chapter10._3_java_dsl_pattern.method_chain.builder;

import chapter10._3_java_dsl_pattern.model.Stock;
import chapter10._3_java_dsl_pattern.model.Trade;

public class StockBuilder {
    private final MethodChainingOrderBuilder builder;
    private final Trade trade;
    private final Stock stock = new Stock();

    protected StockBuilder(
            MethodChainingOrderBuilder builder,
            Trade trade,
            String symbol
    ) {
        this.builder = builder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    public TradeBuilderWithStock on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return new TradeBuilderWithStock(builder, trade);
    }
}