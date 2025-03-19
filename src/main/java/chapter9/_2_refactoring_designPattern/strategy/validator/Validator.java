package chapter9._2_refactoring_designPattern.strategy.validator;

import chapter9._2_refactoring_designPattern.strategy.ValidationStrategy;

public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}