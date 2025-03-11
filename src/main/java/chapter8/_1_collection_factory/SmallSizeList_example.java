package chapter8._1_collection_factory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmallSizeList_example {

    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();
        friends.add("James");
        friends.add("Jane");
        friends.add("John");

        List<String> friendsList = Arrays.asList("James", "Jane", "John");
        friendsList.set(0, "Jeff");

        //UnsupportedOperationException 발생
        friendsList.add("Bardy");

        Set<String> friendsSet = new HashSet<>(Arrays.asList("James", "Jane", "John"));
        Set<String> friendsSetFromStream = Stream.of("James", "Jane", "John")
                .collect(Collectors.toSet());
    }
}
