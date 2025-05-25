package chapter15._2_sync_async;

public class Sync {

    protected static int f(int x) {
        return x+1;
    }

    protected static int g(int x) {
        return x*2;
    }

    public static void main(String[] args) {
        int x = 10;

        int y = f(x);
        int z = g(x);
        System.out.println(y + z);
    }
}
