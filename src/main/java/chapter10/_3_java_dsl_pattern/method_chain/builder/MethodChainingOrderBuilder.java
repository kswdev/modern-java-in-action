package chapter10._3_java_dsl_pattern.method_chain.builder;

import chapter10._3_java_dsl_pattern.model.Order;
import chapter10._3_java_dsl_pattern.model.Trade;

public class MethodChainingOrderBuilder {

    public final Order order = new Order();

    private MethodChainingOrderBuilder(String customer) {
        order.setCustomer(customer);
    }

    // 고객의 주문을 만드는 정적 팩토리 메서드
    public static MethodChainingOrderBuilder forCustomer(String customer) {
        return new MethodChainingOrderBuilder(customer);
    }

    public TradeBuilder buy(int quantity) {
        // 주식을 사는 TradeBuilder 생성
        return new TradeBuilder(this, Trade.Type.BUY, quantity);
    }

    public TradeBuilder sell(int quantity) {
        return new TradeBuilder(this, Trade.Type.SELL, quantity);
    }

    public MethodChainingOrderBuilder addTrade(Trade trade) {
        // 주문에 주식을 추가
        order.addTrade(trade);
        // 유연하게 추가 주문을 만들어 추가할 수 있도록 주문 빌더 자체를 반환
        return this;
    }

    public Order end() {
        return order;
    }
}