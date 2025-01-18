package chapter3._4_method_reference;

import common.apple.Apple;
import common.comparator.AppleComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {

    private static List<Apple> inventory = new ArrayList<>();

    public static void main(String[] args) {
        inventory.sort((Apple a1, Apple a2) ->
                a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort(comparing(Apple::getWeight));

        //1단계 코드 전달
        inventory.sort(new AppleComparator());


        //2단계 익명 클래스 사용
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        //3람다 표현식 사용
        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));

        Comparator<Apple> c = Comparator.comparing((a) -> a.getWeight());
        inventory.sort(c);

        inventory.sort(Comparator.comparing((a) -> a.getWeight()));


        inventory.sort(Comparator.comparing(Apple::getWeight));
    }
}
