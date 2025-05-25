package chapter15._5_pub_sub_reactive.cell;

import chapter15._5_pub_sub_reactive.api.Publisher;
import chapter15._5_pub_sub_reactive.api.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SimpleCell implements
        Publisher<Integer>,
        Subscriber<Integer> {
    private int value = 0;
    private String name;
    private List<Subscriber<? super Integer>> subscribers = new ArrayList<>();

    public SimpleCell(String name) { this.name = name; }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    private void notifyAllSubscribers() {
        subscribers.forEach(subscriber -> subscriber.onNext(this.value));
    }

    @Override
    public void onNext(Integer newValue) {
        this.value = newValue;
        System.out.println(name + " : " + value);
        notifyAllSubscribers();
    }
}
