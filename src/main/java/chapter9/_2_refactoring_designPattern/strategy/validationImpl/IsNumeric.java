package chapter9._2_refactoring_designPattern.strategy.validationImpl;

import chapter9._2_refactoring_designPattern.strategy.ValidationStrategy;

public class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
