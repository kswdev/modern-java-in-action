package chapter11._2_optional_pattern;

import chapter11.common.Insurance;
import chapter11.common.Person;
import chapter11.common.car.Car;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream_manipulation {

    public static void main(String[] args) {

    }

    public Set<String> getCarInsuranceNames(List<Person> people) {
        return people.stream()
                // Optional<Car> 스트림으로 반환
                .map(Person::getCar)
                // flatMap 연산을 이용해 Optional<Car> 를 해당 Optional<Insurance> 로 반환
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                // Optional<Insurance> 를 해당 이름의 Optional<String> 으로 매핑
                .map(optInsurance -> optInsurance.map(Insurance::getName))
                // Stream<Optional<String>>을 현재 이름을 포함하는 Stream<String> 으로 변환
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }

    public Set<String> getCarInsuranceNames2(List<Person> people) {
        return people.stream()
                // Optional<Car> 스트림으로 반환
                .map(Person::getCar)
                // flatMap 연산을 이용해 Optional<Car> 를 해당 Optional<Insurance> 로 반환
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                // Optional<Insurance> 를 해당 이름의 Optional<String> 으로 매핑
                .map(optInsurance -> optInsurance.map(Insurance::getName))
                // Stream<Optional<String>>을 현재 이름을 포함하는 Stream<String> 으로 변환
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
