package chapter8._3_MapProcessing;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Merge_example {

    public static void main(String[] args) {

        // putAll 메서드를 이용한 일반적인 Map 합침
        // 중복된 키 값은 나중에 합쳐지는 Map 의 중복된 키의 값이 덮어씌어진다.
        Map<String, String> family = Map.ofEntries(entry("Teo", "Star Wars"),
                                                   entry("Tom", "The Matrix"));

        Map<String, String> friends = Map.ofEntries(entry("Raphael", "Star Wars"),
                                                    entry("James", "Lion king"));

        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);
        //System.out.println(everyone);

        // merge 를 이용해 BiFunction 을 인수로 받아 중복된 키 값을 처리할 수 있다.
        Map<String, String> boys = Map.ofEntries(entry("James", "Star Wars"),
                                                 entry("Tom", "The Matrix"),
                                                 entry("Kim", "D War"));

        Map<String, String> girls = Map.ofEntries(entry("Jane", "Star Wars"),
                                                  entry("Christina", "Lion king"),
                                                  entry("Kim", "God Father"));

        Map<String, String> students = new HashMap<>(boys);
        girls.forEach((friend, movie) -> {
            students.merge(friend, movie, (boysMovie, girlsMovie) -> boysMovie + " & " + girlsMovie);
        });

        //System.out.println(students);



        /*
         * 영화를 몇 번 시청했는지 기록하는 맵
         *
         */

        // merge 를 이용하지 않은 초기화 검사
        Map<String, Long> moviesToCount = new HashMap<>();
        String movie = "The Matrix";
        Long count = moviesToCount.get(movie);
        if (count == null) {
            moviesToCount.put(movie, 1L);
        }
        else {
            moviesToCount.put(movie, count + 1);
        }

        // merge 를 이용한 초기화 검사
        // 키에 연관된 값이 없으면 두 번째 인수 3L로 초기화
        // 키에 연관된 앖이 있으면 세 번재 BiConsumer 구현체로 첫 번째 기존 값과 두 번째 increment 3L 과 합친 결과를 키에 매핑한다.
        moviesToCount.merge(movie, 1L, (cnt, increment) -> cnt + 1L);
        System.out.println(moviesToCount);
    }
}
