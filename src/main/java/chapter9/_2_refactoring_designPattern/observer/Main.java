package chapter9._2_refactoring_designPattern.observer;

import chapter9._2_refactoring_designPattern.observer.observerConcrete.Guardian;
import chapter9._2_refactoring_designPattern.observer.observerConcrete.NYTimes;
import chapter9._2_refactoring_designPattern.observer.subject.concrete.Subscribe;

public class Main {

    public static void main(String[] args) {
        Subscribe subscribe = new Subscribe();
        subscribe.registerObserver(new NYTimes());
        subscribe.registerObserver(new Guardian());
        subscribe.notifyObservers("money is back!");

        subscribe.registerObserver((String message) -> {
            if (message.contains("money")) {
                System.out.println("Breaking news in NY! " + message);
            }
        });
    }
}
