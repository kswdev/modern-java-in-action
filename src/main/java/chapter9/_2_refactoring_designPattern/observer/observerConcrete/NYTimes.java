package chapter9._2_refactoring_designPattern.observer.observerConcrete;

import chapter9._2_refactoring_designPattern.observer.Observer;

public class NYTimes implements Observer {

    @Override
    public void notify(String message) {
        if (message != null && message.contains("money")) {
            System.out.println("Breaking news in NY! " + message);
        }
    }
}
