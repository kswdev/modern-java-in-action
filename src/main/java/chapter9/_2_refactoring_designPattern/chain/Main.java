package chapter9._2_refactoring_designPattern.chain;

import chapter9._2_refactoring_designPattern.chain.concrete.HeaderTextProcessing;
import chapter9._2_refactoring_designPattern.chain.concrete.SpellCheckerProcessing;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Are not labdas really cool?");
        System.out.println(result);

        UnaryOperator<String> headerProcessing =
                text -> "From Raoul, Mario and Alan: " + text;

        UnaryOperator<String> spellCheckerProcessing =
                text -> text.replace("labda", "lambda");

        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);

        result = pipeline.apply("Are not labdas really cool?");
        System.out.println(result);
    }
}
