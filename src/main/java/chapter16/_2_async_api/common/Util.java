package chapter16._2_async_api.common;

import java.util.Random;

public abstract class Util {

    public static Random random = new Random();

    public static void delay(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
