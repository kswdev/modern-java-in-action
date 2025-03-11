package chapter8._1_collection_factory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StaticFactoryMethod_example {

    public static void main(String[] args) {

        /*
         * List FactoryMethod
         */
        List<String> friends =
                List.of("John", "Jane", "Mary");

        //UnsupportedOperationException 발생
        friends.set(1, "Jack");


        /*
         * Set FactoryMethod
         */
        Set<String> friendsSet =
                Set.of("John", "Jane", "Mary");

        //IllegalArgumentException 발생
        Set<String> friendsSetWithException =
                Set.of("Jane", "John", "Mary", "Jane");


        /*
         * Map FactoryMethod
         */

        //elements.length is less than 10
        Map<String, Integer> ageOfFriends =
                Map.of("Jane", 30, "John", 25, "Mary", 20);

        //elements.length is larger than 10
        Map<String, Integer> ageOfFriends2 =
                Map.ofEntries(
                        Map.entry("Jane", 30),
                        Map.entry("John", 25),
                        Map.entry("Mary", 20)
                );
    }
}
