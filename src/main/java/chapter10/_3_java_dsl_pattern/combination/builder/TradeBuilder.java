package chapter10._3_java_dsl_pattern.combination.builder;

import chapter10._3_java_dsl_pattern.model.Trade;

public class TradeBuilder {

    private Trade trade = new Trade();

    protected Trade getTrade() {
        return trade;
    }

    public TradeBuilder quantity(int quantity) {
        trade.setQuantity(quantity);
        return this;
    }

    public TradeBuilder at(double price) {
        trade.setPrice(price);
        return this;
    }

    public StockBuilder stock(String symbol) {
        return new StockBuilder(this, trade, symbol);
    }
}