package chapter9._2_refactoring_designPattern.chain.concrete;

import chapter9._2_refactoring_designPattern.chain.ProcessingObject;

public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: " + input;
    }
}
