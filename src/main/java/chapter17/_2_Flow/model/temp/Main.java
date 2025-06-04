package chapter17._2_Flow.model.temp;

import chapter17.common.TempInfo;

import static java.util.concurrent.Flow.Publisher;

public class Main {

    public static void main(String[] args) {
        // 뉴엑에 새 Publisher를 만들고 구독을 시작한다.
        //getTemperature("Seoul").subscribe(new TempSubscriber());
        getCelsiusTemperature("Seoul").subscribe(new TempSubscriber());
    }

    private static Publisher<TempInfo> getTemperature(String town) {
        return subscriber -> subscriber.onSubscribe(
                new TempSubscription(subscriber, town));
    }

    public static Publisher<TempInfo> getCelsiusTemperature(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }
}
