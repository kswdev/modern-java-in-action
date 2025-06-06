package chapter19._5_etc.combinator;

import java.util.function.Function;

public abstract class Combinator<A, B, C> {

    public static void main(String[] args) {

    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> g, Function<A, B> f) {
        return x -> g.apply(f.apply(x));
    }
}
