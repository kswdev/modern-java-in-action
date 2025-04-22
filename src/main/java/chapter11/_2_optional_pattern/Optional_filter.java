package chapter11._2_optional_pattern;

import chapter11.common.Insurance;
import chapter11.common.Person;
import chapter11.common.car.Car;

import java.util.Optional;

public class Optional_filter {

    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        if (insurance != null && insurance.getName().equals("CambridgeInsurance")) {
            System.out.println("ok");
        }

        // filter
        Optional<Insurance> optInsurance = Optional.of(insurance);
        optInsurance
                .filter(insurance1 -> insurance1.getName().equals("CambridgeInsurance"))
                .ifPresent(insurance1 -> System.out.println("ok"));

    }

    public String getCarInsuranceName(Optional<Person> optPerson, int minAge) {
        return optPerson
                .filter(person -> person.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("No Insurance");
    }
}
