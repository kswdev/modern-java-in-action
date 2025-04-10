package common.person;

import common.car.Car;

public class Person {
    private String name;
    private int age;
    private Car car;

    public String getName() { return name; }

    public int getAge() { return age; }

    public Car getCar() { return car; }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}