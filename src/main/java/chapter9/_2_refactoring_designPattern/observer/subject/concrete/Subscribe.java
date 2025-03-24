package chapter9._2_refactoring_designPattern.observer.subject.concrete;

import chapter9._2_refactoring_designPattern.observer.Observer;
import chapter9._2_refactoring_designPattern.observer.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class Subscribe implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.notify(message));
    }
}
