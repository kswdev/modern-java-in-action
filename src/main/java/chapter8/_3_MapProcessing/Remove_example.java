package chapter8._3_MapProcessing;

import chapter8.common.FriendsFactory;

import java.util.Map;

public class Remove_example {

    public static void main(String[] args) {
        Map<String, String> favoriteMovies = FriendsFactory.favoriteMovies;

        //전통적인 방법
        String key = "Tom";
        String value = "Lion King";
        if (favoriteMovies.containsKey(key) && favoriteMovies.get(key).equals(value)) {
            favoriteMovies.remove(key);
            System.out.println("Removed " + key + " from " + value);
        }

        //remove 메서드
        favoriteMovies.remove(key, value);
    }
}
