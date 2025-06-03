package chapter17._2_Flow.model.temp;

import static java.util.concurrent.Flow.*;

public class TempSubscription implements Subscription {

    private final Subscriber<? super TempInfo> subscriber;
    private final String town;

    public TempSubscription(Subscriber<? super TempInfo> subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    @Override
    public void request(long n) {

        // 요청을 한 개씩 전달
        for (long i = 0L; i < n; i++) {
            try {
                // 현재 온드를 Subscription 에게 전달
                subscriber.onNext(TempInfo.fetch(town));
            } catch (Exception e) {
                subscriber.onError(e);
                break;
            }
        }
    }

    @Override
    public void cancel() {

        // 구독이 취소되면 완료 신호를 보내고 Subscriber 에게 전달
        subscriber.onComplete();
    }
}
