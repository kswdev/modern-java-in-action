package chapter18._2_Functional_example;

import common.apple.Apple;

import java.util.Iterator;
import java.util.List;

public class Iteration {

    // 문제 없는 반복문
    private void appleIterator(List<Apple> apples) {
        Iterator<Apple> it = apples.iterator();
        while (it.hasNext()) {
            Apple apple = it.next();
            // ...
        }
    }

    // 루프 내부에서 프로그램의 다른 부분과 공유되는 stat 객체의 상태를 변화시킨다
    private void searchForGold(List<String> l, Stat stat) {
        for (String s : l) {
            if ("gold".equals(s)) {
                stat.incrementFor("gold");
            }
        }
    }

    private static class Stat {
        void incrementFor(String stat) {

        }
    }
}
