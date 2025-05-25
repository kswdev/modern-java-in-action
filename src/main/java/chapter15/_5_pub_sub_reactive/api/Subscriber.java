package chapter15._5_pub_sub_reactive.api;

public interface Subscriber<T> {
    void onNext(T t);
}
