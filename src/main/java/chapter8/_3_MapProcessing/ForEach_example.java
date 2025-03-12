package chapter8._3_MapProcessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEach_example {

    public static void main(String[] args) {

        Map<String, Integer> ageOfFriends =
                Map.of("Jane", 30, "John", 25, "Mary", 20);

        // 전통적인 맵 반복문
        for (Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + " is " + age + " years old.");
        }

        // forEach 메서드를 통한 반복문
        ageOfFriends.forEach((friend, age) -> {
            System.out.println(friend + " is " + age + " years old.");
        });
    }
}
