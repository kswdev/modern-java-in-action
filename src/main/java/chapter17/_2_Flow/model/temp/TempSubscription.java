package chapter17._2_Flow.model.temp;

import chapter17.common.TempInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Flow.*;

public class TempSubscription implements Subscription {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Subscriber<? super TempInfo> subscriber;
    private final String town;

    public TempSubscription(Subscriber<? super TempInfo> subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    @Override
    public void request(long n) {
        // 다른 스레드에서 다음 요소를 구독자에게 보낸다.
        executor.submit(() -> {
            for (long i = 0L; i < n; i++) {
                try {
                    // 현재 온드를 Subscription 에게 전달
                    subscriber.onNext(TempInfo.fetch(town));
                } catch (Exception e) {
                    subscriber.onError(e);
                    break;
                }
            }
        });
    }

    @Override
    public void cancel() {

        // 구독이 취소되면 완료 신호를 보내고 Subscriber 에게 전달
        subscriber.onComplete();
    }
}
