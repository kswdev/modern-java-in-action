package chapter9._2_refactoring_designPattern.strategy;

import chapter9._2_refactoring_designPattern.strategy.validationImpl.IsAllLowerCase;
import chapter9._2_refactoring_designPattern.strategy.validationImpl.IsNumeric;
import chapter9._2_refactoring_designPattern.strategy.validator.Validator;

public class Main {

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());

        boolean b1 = numericValidator.validate("data");
        boolean b2 = lowerCaseValidator.validate("babel");

        System.out.println(b1);
        System.out.println(b2);

        numericValidator = new Validator((s) -> s.matches("[0-9]+"));
        lowerCaseValidator = new Validator((s) -> s.matches("[a-z]+"));

        boolean b3 = numericValidator.validate("data");
        boolean b4 = lowerCaseValidator.validate("babel");

        System.out.println(b3);
        System.out.println(b4);
    }
}
