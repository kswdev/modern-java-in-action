package chapter17._2_Flow.model.temp;

import chapter17.common.TempInfo;

import java.util.concurrent.Flow;

import static java.util.concurrent.Flow.*;

public class TempSubscriber implements Flow.Subscriber<TempInfo> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        // 구독을 저장하고 첫 번째 요청을 전달
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(TempInfo item) {
        // 수신한 온도를 출력하고 다음 정보를 요청
        System.out.println(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        // 에러가 발생하면 에러 메시지 출력
        System.err.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Done!");
    }
}
