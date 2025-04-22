package chapter11._2_optional_pattern;

import chapter11.common.Insurance;
import chapter11.common.Person;
import chapter11.common.car.Car;

import java.util.Optional;

public class Merge_optional {

    public static void main(String[] args) {

    }

    public Optional<Insurance> findCheapestInsurance(
            Optional<Person> optPerson, Optional<Car> optCar
    ) {
        if (optPerson.isPresent() && optCar.isPresent()) {
            return Optional.of(findCheapestInsurance(optPerson.get(), optCar.get()));
        } else {
            return Optional.empty();
        }
    }

    // 조건문 없이 만들기
    public Optional<Insurance> findCheapestInsuranceWithoutIf(
            Optional<Person> optPerson, Optional<Car> optCar
    ) {
        return optPerson.flatMap(person ->
                optCar.map(car -> findCheapestInsurance(person, car))
        );
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        // 다양한 보험회사가 제공하는 서비스 조회
        // 모든 결과 데이터 비교
        return new Insurance();
    }
}
