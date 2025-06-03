package chapter16._5_react_end_of_completableFuture.domain.shop;

import chapter16._5_react_end_of_completableFuture.domain.discount.Discount;

import static chapter16.common.Util.*;

public class Shop {

    private String name;
    private double price;

    public Shop(String name) {
        this.name = name;
    }

    public Shop() {}

    public String getPrice(String product) {
        double price = calculatePrice(product);
        // 임의로 마지막 코드 적용
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        //delay(1);
        randomDelay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public String getName() {
        return name;
    }
}
