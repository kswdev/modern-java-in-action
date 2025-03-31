package chapter10._2_java8_smallest_DSL;

import chapter10._2_java8_smallest_DSL.common.car.*;
import chapter10._2_java8_smallest_DSL.common.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import static chapter10._2_java8_smallest_DSL.common.GroupingBuilder.groupOn;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.groupingBy;

public class DSL_Collector {

    private static final List<Car> cars = List.of(
            new Ioniq(Color.BLUE),
            new Kona(Color.RED),
            new Odyssey(Color.RED),
            new Accord(Color.GRAY)
    );

    private static final List<Person> persons = List.of(
            new Person("John", 19),
            new Person("James", 13),
            new Person("Son", 17),
            new Person("Harry", 27)
    );

    public static void main(String[] args) {
        Map<Brand, Map<Color, List<Car>>> carsByBrandAndColor =
            cars.stream().collect(
                    groupingBy(Car::getBrand, groupingBy(Car::getColor)));

        System.out.println(carsByBrandAndColor);

        // 두 Comparator 를 플루언트 방식으로 연결해서 다중 필드 Comparator 정의
        Comparator<Person> comparator =
                comparing(Person::age).thenComparing(Person::name);

        // Collectors 를 중첩함으로 다중 수준 Collector
        Collector<? super Car, ?, Map<Brand, Map<Color, List<Car>>>> carGroupingByBrandAndColor =
                groupingBy(Car::getBrand, groupingBy(Car::getColor));

        Collector<? super Car, ?, Map<Brand, Map<Color, List<Car>>>> carGroupingByBrandAndColor2 =
                groupingBy(Car::getBrand, groupingBy(Car::getColor));

        Collector<? super Car, ?, Map<Brand, Map<Color, List<Car>>>> carGroupingByBrandAndColor3 =
                groupOn(Car::getColor).after(Car::getBrand).get();
    }
}
