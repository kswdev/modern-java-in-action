package chapter8._3_MapProcessing;

import java.util.HashMap;
import java.util.Map;

public class Replace_example {

    public static void main(String[] args) {

        // replace, replaceAll
        Map<String, String> favoriteMovies = new HashMap<>();
        favoriteMovies.put("Raphael", "Star wars");
        favoriteMovies.put("James", "Lion king");
        favoriteMovies.replace("James", "James bond");
        favoriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
        favoriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
        System.out.println(favoriteMovies);
    }
}
