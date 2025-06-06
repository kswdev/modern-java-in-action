package chapter19._3_stream_and_lazy_eval.lazy_list;

public abstract class StreamFactory {

    public static void main(String[] args) {
        LazyList<Integer> numbers = from(2);
        int two = primes(numbers).head();
        int three = primes(numbers).tail().head();
        int five = primes(numbers).tail().tail().head();
        System.out.println(two + " " + three + " " + five);
    }

    private static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(
                numbers.head(),
                () -> primes(
                        numbers.tail()
                                .filter(n -> n % numbers.head() != 0)
                )
        );
    }

    private static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n+1));
    }
}
