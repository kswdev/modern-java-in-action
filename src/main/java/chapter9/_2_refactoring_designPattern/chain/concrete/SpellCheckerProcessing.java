package chapter9._2_refactoring_designPattern.chain.concrete;

import chapter9._2_refactoring_designPattern.chain.ProcessingObject;

public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
