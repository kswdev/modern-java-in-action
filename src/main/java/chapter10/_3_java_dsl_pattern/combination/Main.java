package chapter10._3_java_dsl_pattern.combination;

import chapter10._3_java_dsl_pattern.model.Order;

import static chapter10._3_java_dsl_pattern.combination.builder.MixedBuilder.*;

public class Main {

    public static void main(String[] args) {
        Order order =
                // 최상위 수주 주무이 속성ㅇㄹ 지정하느 중첩 함수
                forCustomer("BigBank",
                            // 한 개의 주문을 마느는 람다 표현식
                            buy(t -> t.quantity(80)
                                                  // 거래 객체를 만드는 람다 표현식 바디의
                                                  // 메서드 체인
                                                  .stock("IBM")
                                                  .on("NYSE")
                                                  .at(125.00)),
                            sell(t -> t.quantity(50)
                                                   .stock("GOOGLE")
                                                   .on("NASDAQ")
                                                   .at(375.00)));
    }
}