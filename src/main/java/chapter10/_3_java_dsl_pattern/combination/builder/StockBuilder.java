package chapter10._3_java_dsl_pattern.combination.builder;

import chapter10._3_java_dsl_pattern.model.Stock;
import chapter10._3_java_dsl_pattern.model.Trade;

public class StockBuilder {

    private final TradeBuilder builder;
    private final Trade trade;
    private final Stock stock = new Stock();

    public StockBuilder(TradeBuilder builder, Trade trade, String symbol) {
        this.builder = builder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    public TradeBuilder on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return builder;
    }
}