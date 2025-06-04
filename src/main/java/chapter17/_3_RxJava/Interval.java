package chapter17._3_RxJava;

import chapter17.common.TempInfo;
import io.reactivex.rxjava3.core.Observable;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Interval {

    public static void main(String[] args) {
        Observable<String> strings = Observable.just("Hello", "World");

        // 사용자와 실시간으로 상호작용하면서 지정된 속도로 이벤트를 방출
        Observable<Long> onePerSec = Observable.interval(1,  SECONDS);



        onePerSec.blockingSubscribe(
                i -> System.out.println(TempInfo.fetch("New York")));
    }
}
