package chapter16._3_non_blocking_code;

import static chapter16._3_non_blocking_code.common.Shops.*;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(asyncFindPricesAsync("myPhone"));
        long duration = System.currentTimeMillis() - start;
        System.out.println("Time taken: " + duration);
    }
}
