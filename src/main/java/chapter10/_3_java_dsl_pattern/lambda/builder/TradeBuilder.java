package chapter10._3_java_dsl_pattern.lambda.builder;

import chapter10._3_java_dsl_pattern.model.Trade;

import java.util.function.Consumer;

public class TradeBuilder {

    private Trade trade = new Trade();

    public void quantity(int quantity) {
        trade.setQuantity(quantity);
    }

    public void price(double price) {
        trade.setPrice(price);
    }

    public void stock(Consumer<StockBuilder> consumer) {
        StockBuilder builder = new StockBuilder();
        consumer.accept(builder);
        trade.setStock(builder.getStock());
    }

    protected Trade getTrade() {
        return trade;
    }
}
