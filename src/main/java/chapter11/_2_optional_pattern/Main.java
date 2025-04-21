package chapter11._2_optional_pattern;

import chapter11.common.car.Car;
import chapter11.common.car.Color;
import chapter11.common.car.Ioniq;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Car car = new Ioniq(Color.BLUE);

        // 빈 Optional
        Optional<Car> optCar = Optional.empty();

        // null 이 아닌 값으로 Optional 만들기
        Optional<Car> optCar2 = Optional.of(car);

        // null 값으로 Optional 만들기
        Optional<Car> optCar3 = Optional.ofNullable(car);
    }
}
