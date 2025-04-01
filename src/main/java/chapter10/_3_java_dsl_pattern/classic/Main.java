package chapter10._3_java_dsl_pattern.classic;

import chapter10._3_java_dsl_pattern.model.Order;
import chapter10._3_java_dsl_pattern.model.Stock;
import chapter10._3_java_dsl_pattern.model.Trade;

public class Main {

    public static void main(String[] args) {
        Stock stock = new Stock();
        stock.setSymbol("IBM");
        stock.setMarket( "NYSE");

        Trade trade = new Trade();
        trade.setType(Trade.Type.BUY);
        trade.setStock(stock);
        trade.setPrice(125.00);
        trade.setQuantity(80);

        Stock stock2 = new Stock();
        stock2.setSymbol("MSFT");
        stock2.setMarket( "NYSE");

        Trade trade2 = new Trade();
        trade2.setType(Trade.Type.BUY);
        trade2.setStock(stock2);
        trade2.setPrice(80.00);
        trade2.setQuantity(100);

        Order order = new Order();
        order.setCustomer( "John");
        order.addTrade(trade);
        order.addTrade(trade2);
    }
}
