package chapter16._4_async_pipeline;

import static chapter16._4_async_pipeline.domain.shop.Shops.*;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(asyncAndSyncFindPrices("myPhone"));
        long duration = System.currentTimeMillis() - start;
        System.out.println("Time taken: " + duration);
    }
}
