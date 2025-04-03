package chapter10._3_java_dsl_pattern.lambda.builder;

import chapter10._3_java_dsl_pattern.model.Stock;

public class StockBuilder {
    private Stock stock = new Stock();

    public void symbol(String symbol) {
        stock.setSymbol(symbol);
    }

    public void market(String market) {
        stock.setMarket(market);
    }

    protected Stock getStock() {
        return stock;
    }
}