package chapter15._2_sync_async.block;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {
        ScheduledExecutorService service =
                Executors.newScheduledThreadPool(1);

        work1();
        service.schedule(
                ScheduledExecutorServiceExample::work2, 10, TimeUnit.SECONDS);

        service.shutdown();
    }

    private static void work1() {
        System.out.println("work1");
    }

    private static void work2() {
        System.out.println("work2");
    }
}
