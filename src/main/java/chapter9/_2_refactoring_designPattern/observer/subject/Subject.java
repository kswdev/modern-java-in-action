package chapter9._2_refactoring_designPattern.observer.subject;

import chapter9._2_refactoring_designPattern.observer.Observer;

public interface Subject {

    void registerObserver(Observer observer);
    void notifyObservers(String message);
}