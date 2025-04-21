package chapter11._2_optional_pattern;

import chapter11.common.Insurance;
import chapter11.common.Person;
import chapter11.common.car.Car;
import chapter11.common.car.Color;
import chapter11.common.car.Ioniq;

import java.util.Optional;

public class ExtractByMap {

    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        String name = null;
        if (insurance != null)
            name = insurance.getName();

        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> optName = optInsurance.map(Insurance::getName);

        Person person = new Person("John", 10);

        Optional<Person> optPerson = Optional.of(person);
        // 변수 optPerson의 형식은 Optional<Person>이므로 map 메서드를 호출할 수 있다.
        // 하지만 getCar는 Optional<Car> 형식의 객체를 반환한다.
        /* Optional<String> optName2 =
                optPerson.map(Person::getCar)
                         .map(Car::getInsurance)
                         .map(Insurance::getName); */

    }

    public String getCarInsurance(Optional<Person> optPerson) {
        return optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("No Insurance");
    }

}
