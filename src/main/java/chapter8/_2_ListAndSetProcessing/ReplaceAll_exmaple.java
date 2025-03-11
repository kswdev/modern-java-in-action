package chapter8._2_ListAndSetProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ReplaceAll_exmaple {

    public static void main(String[] args) {
        List<String> referenceCodes = new ArrayList<>();
        referenceCodes.add("acs");
        referenceCodes.add("ssd");
        referenceCodes.add("gcd");
        referenceCodes.add("cte");
        referenceCodes.add("csy");
        referenceCodes.add("psy");
        referenceCodes.add("cio");
        referenceCodes.add("zxc");

        referenceCodes.stream()
                .map(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1))
                .toList()
                .forEach(System.out::println);

        for (ListIterator<String> iterator = referenceCodes.listIterator();
             iterator.hasNext(); ) {

            String code = iterator.next();
            iterator.set(Character.toUpperCase(code.charAt(0)) + code.substring(1));
        }

        //replaceAll
        referenceCodes.replaceAll(code ->
                Character.toUpperCase(code.charAt(0)) + code.substring(1));
    }
}
