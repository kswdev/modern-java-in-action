package chapter9._2_refactoring_designPattern.templateMethod.concrete;

import chapter9._2_refactoring_designPattern.templateMethod.OnlineBanking;
import chapter9._2_refactoring_designPattern.templateMethod.customer.Customer;

public class OnlineBankingLambda extends OnlineBanking {


    @Override
    public void makeCustomerHappy(Customer c) {
        // 람다식을 넘길 계획이라 굳이 구현 안해도 됨
    }
}
