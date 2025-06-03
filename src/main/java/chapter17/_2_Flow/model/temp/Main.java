package chapter17._2_Flow.model.temp;

import static java.util.concurrent.Flow.Publisher;

public class Main {

    public static void main(String[] args) {
        // 뉴엑에 새 Publisher를 만들고 구독을 시작한다.
        getTemperature("Seoul").subscribe(new TempSubscriber());
    }

    private static Publisher<TempInfo> getTemperature(String town) {
        return subscriber -> subscriber.onSubscribe(
                new TempSubscription(subscriber, town));
    }
}
