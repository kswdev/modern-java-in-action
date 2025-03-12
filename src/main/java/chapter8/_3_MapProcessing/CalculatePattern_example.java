package chapter8._3_MapProcessing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class CalculatePattern_example {

    private final static Map<String, byte[]> dataToHash = new HashMap<>();
    private final static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<String> lines = List.of("Jane", "John", "Mary");

        // computeIfAbsent
        lines.forEach(line ->
                dataToHash.computeIfAbsent(line, CalculatePattern_example::calculateDigest));


        //전통적인 방법 - 키를 조회해 List 값에 요소를 추가하기 전 초기화를 확읺
        Map<String, List<String>> friendsToMovies = new HashMap<>();

        String friend = "Jane";

        List<String> movies = friendsToMovies.get(friend);
        if (movies == null) {
            movies = new ArrayList<>();
            friendsToMovies.put(friend, movies);
        }
        movies.add("The Godfather");
        System.out.println(friendsToMovies);

        // computeIfAbsent - 개선된 방법
        friendsToMovies.computeIfAbsent(friend, k -> new ArrayList<>())
                .add("The GodFather");
    }

    private static byte[] calculateDigest(String key) {
        return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
    }
}
