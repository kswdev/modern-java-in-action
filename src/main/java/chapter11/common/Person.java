package chapter11.common;

import chapter11.common.car.Car;

import java.util.Optional;

public class Person {
    private String name;
    private int age;
    private Optional<Car> car;

    public String getName() { return name; }

    public int getAge() { return age; }

    public Optional<Car> getCar() { return car; }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setCar(Optional<Car> car) { this.car = car; }
}
