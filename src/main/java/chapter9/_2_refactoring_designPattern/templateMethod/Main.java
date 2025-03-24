package chapter9._2_refactoring_designPattern.templateMethod;

import chapter9._2_refactoring_designPattern.templateMethod.concrete.OnlineBankingLambda;

public class Main {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1, (customer) ->
                        System.out.println("Hello " + customer.getName()));

    }
}
