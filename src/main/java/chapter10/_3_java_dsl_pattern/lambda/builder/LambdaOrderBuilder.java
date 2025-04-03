package chapter10._3_java_dsl_pattern.lambda.builder;

import chapter10._3_java_dsl_pattern.model.Order;
import chapter10._3_java_dsl_pattern.model.Trade;

import java.util.function.Consumer;

public class LambdaOrderBuilder {

    // 빌더로 주문을 감쌈
    private Order order = new Order();

    public static Order order(Consumer<LambdaOrderBuilder> consumer) {
        LambdaOrderBuilder builder = new LambdaOrderBuilder();
        // 주문 빌더로 번달된 람다 표현식 실행
        consumer.accept(builder);
        //OrderBuilder 의 Consumer 를 실행해 만들어진 주문을 반환
        return builder.order;
    }

    public void forCustomer(String customer) {
        // 주문을 요청한 고객 설정
        order.setCustomer(customer);
    }

    public void buy(Consumer<TradeBuilder> consumer) {
        // 주식 매수 주문을 만들도록 TradeBuilder 소비
        trade(consumer, Trade.Type.BUY);
    }

    public void sell(Consumer<TradeBuilder> consumer) {
        // 주식 매도 주문을 만들도록 TradeBuilder 소비
        trade(consumer, Trade.Type.SELL);
    }

    private void trade(Consumer<TradeBuilder> consumer, Trade.Type type) {
        TradeBuilder builder = new TradeBuilder();
        builder.getTrade().setType(type);
        // TradeBuilder 로 전달할 람다 표현식 실행
        consumer.accept(builder);
        // TradeBuilder 의 Consumer 를 싫애해 만든 거래를 주문에 추가
        order.addTrade(builder.getTrade());
    }
}
