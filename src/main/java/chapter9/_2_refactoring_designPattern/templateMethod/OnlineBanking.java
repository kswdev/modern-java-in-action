package chapter9._2_refactoring_designPattern.templateMethod;

import chapter9._2_refactoring_designPattern.templateMethod.customer.Customer;
import chapter9._2_refactoring_designPattern.templateMethod.database.Database;

import java.util.function.Consumer;

public abstract class OnlineBanking {

    //일반적인 방법. 구현체에 로직을 작성한다.
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    //함수적 인터페이스를 인수로 받는 법
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    public abstract void makeCustomerHappy(Customer c);
}
