package chapter19._5_etc.combinator;

import java.util.function.Function;

import static chapter19._5_etc.combinator.Combinator.compose;

public abstract class Repeat<A, B> {

    public static <A> Function<A, A> repeat(int n, Function<A, A> f) {
        return n == 0 ? x ->
                x :
                compose(f, repeat(n-1, f));
    }
}
