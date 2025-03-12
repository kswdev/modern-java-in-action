package chapter8._3_MapProcessing;

import chapter8.common.FriendsFactory;

import java.util.Map;

public class GetOrDefault_example {

    public static void main(String[] args) {
        Map<String, String> favoriteMovies = FriendsFactory.favoriteMovies;

        // getOrDefault 메서드를 통한 키가 없을 경우 기본값 반환
        System.out.println(favoriteMovies.getOrDefault("Tom", "No movie"));
    }
}
