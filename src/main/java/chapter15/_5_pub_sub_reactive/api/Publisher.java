package chapter15._5_pub_sub_reactive.api;

public interface Publisher <T>{
    void subscribe(Subscriber<? super T> subscriber);
}
