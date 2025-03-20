package chapter9._2_refactoring_designPattern.templateMethod.database;

import chapter9._2_refactoring_designPattern.templateMethod.customer.Customer;

public class Database {

    public static Customer getCustomerWithId(int id) {
        return new Customer();
    }
}
