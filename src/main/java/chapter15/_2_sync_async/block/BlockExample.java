package chapter15._2_sync_async.block;

public class BlockExample {

    public static void main(String[] args) throws InterruptedException {
        work1();
        Thread.sleep(1000);
        work2();
    }

    private static void work1() {
        System.out.println("work1");
    }

    private static void work2() {
        System.out.println("work2");
    }
}
