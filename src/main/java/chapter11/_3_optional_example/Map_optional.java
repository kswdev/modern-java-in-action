package chapter11._3_optional_example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Map_optional {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        Object value = map.get("key");

        // Optional 로 감싸기
        Object optValue = Optional.ofNullable(map.get("key"));
    }
}
