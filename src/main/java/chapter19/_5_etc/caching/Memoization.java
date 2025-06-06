package chapter19._5_etc.caching;

import java.util.HashMap;
import java.util.Map;

public class Memoization {

    private final Map<String, Integer> numbersOfNodes = new HashMap<>();

    private int computeNumberOfNodesUsingCache(String name) {
        Integer result = numbersOfNodes.get(name);
        if (result != null) {
            return result;
        }

        result = computeNumberOfNodes(name);
        numbersOfNodes.put(name, result);
        return result;
    }

    private int computeNumberOfNodesUsingCache2(String name) {
        return numbersOfNodes.computeIfAbsent(name, this::computeNumberOfNodes);
    }

    private int computeNumberOfNodes(String name) {
        return 0;
    }
}
