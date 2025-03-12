package chapter8.common;

import java.util.Map;

public abstract class FriendsFactory {
    public static Map<String, String> favoriteMovies
            = Map.ofEntries(Map.entry("Raphael", "Star wars"),
                            Map.entry("Cristina", "Matrix"),
                            Map.entry("Jane", "The Godfather"),
                            Map.entry("John", "The Godfather II"));
}
