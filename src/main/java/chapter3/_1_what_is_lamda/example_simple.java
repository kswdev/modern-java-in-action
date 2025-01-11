package chapter3._1_what_is_lamda;

import common.apple.Apple;

import java.util.Comparator;

public class example_simple {

    public static void main(String[] args) {

        //익명 클래스
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };

        // 람다 코드
        Comparator<Apple> byWeight2 = (o1, o2) -> o1.getWeight().compareTo(o2.getWeight());
    }
}
