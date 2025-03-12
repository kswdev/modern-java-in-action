package chapter8._3_MapProcessing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        String friend = "Raphael";
        List<String> Movies = friends
    }

    private static byte[] calculateDigest(String key) {
        return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
    }
}
