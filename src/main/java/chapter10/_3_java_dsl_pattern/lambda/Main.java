package chapter10._3_java_dsl_pattern.lambda;

import chapter10._3_java_dsl_pattern.model.Order;

import static chapter10._3_java_dsl_pattern.lambda.builder.LambdaOrderBuilder.order;

public class Main {

    /*
     * 장점.
     * 1. 메서드 체인 패턴처럼 플루언트 방식으로 거래 주문을 정의할 수 있다.
     * 2. 중첨 합수 형식처럼 다양한 람다 표현식의 중첩 수준과 비슷하게 도메인 객체의 계층 구조를 유지한다.
     *
     * 단점.
     * 1. 많은 설정 코드가 필요하다
     * 2. 자바의 람다 표현식 문법에 의한 잡음의 영향을 받는다.
     */

    public static void main(String[] args) {
        Order order = order(o -> {
            o.forCustomer("BigBank");
            o.buy(t -> {
                t.quantity(80);
                t.price(125.00);
                t.stock(s -> {
                    s.symbol("IBM");
                    s.market("NYSE");
                });
            });
            o.sell(t -> {
                t.quantity(50);
                t.price(375.00);
                t.stock(s -> {
                    s.symbol("GOOGLE");
                    s.market("NASDAQ");
                });
            });
        });
    }
}