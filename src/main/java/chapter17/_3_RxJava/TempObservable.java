package chapter17._3_RxJava;

import chapter17._3_RxJava.model.temp.TempObserver;
import chapter17.common.TempInfo;
import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TempObservable {

    public static void main(String[] args) {

        Observable<TempInfo> observable = getTemperature("New York");
        //observable.blockingSubscribe(new TempObserver());

        Observable<TempInfo> observable2 = getCelsiusTemperatures(
                "New York",
                        "Chicago",
                        "San Francisco");

        observable2.blockingSubscribe(new TempObserver());
    }

    // Observable map 을 이용한 변환
    public static Observable<TempInfo> getCelsiusTemperature(String town) {
        return getTemperature(town)
                .map(temp -> new TempInfo(temp.getTown(),
                        (temp.getTemp() - 32) * 5 / 9));
    }

    // Observable merge 를 이용해서 한 개 이상 도시의 온도 보고를 합친다.
    public static Observable<TempInfo> getCelsiusTemperatures(String... towns) {
        return Observable.merge(Arrays.stream(towns)
                                      .map(TempObservable::getCelsiusTemperature)
                                      .toList());
    }

    public static Observable<TempInfo> getTemperature(String town) {
        // Observer를 소비하는 함수로부터 Observable을 생성
        return Observable.create(emitter ->
                // 매 초마다 무한으로 증가하는 일련의 long 값을 방출하는 Observable
                Observable.interval(1, SECONDS)
                        .subscribe(i -> {
                            if (!emitter.isDisposed()) {
                                if (i >= 5) {
                                    emitter.onComplete();
                                } else {
                                    try {
                                        emitter.onNext(TempInfo.fetch(town));
                                    } catch (Exception e) {
                                        emitter.onError(e);
                                    }
                                }
                            }
                        })
        );
    }
}
