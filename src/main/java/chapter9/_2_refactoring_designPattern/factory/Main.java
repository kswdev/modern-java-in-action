package chapter9._2_refactoring_designPattern.factory;

import chapter9._2_refactoring_designPattern.factory.classic.ProductFactory;
import chapter9._2_refactoring_designPattern.factory.common.Product;

public class Main {

    public static void main(String[] args) {
        Product p = ProductFactory.createProduct("loan");
    }
}
