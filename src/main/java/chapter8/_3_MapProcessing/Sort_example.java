package chapter8._3_MapProcessing;

import chapter8.common.FriendsFactory;

import java.util.Map;

public class Sort_example {

    public static void main(String[] args) {
        Map<String, String> favoriteMovies = FriendsFactory.favoriteMovies;

        // Map 정렬
        favoriteMovies.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(System.out::println);
    }
}
