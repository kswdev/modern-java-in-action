package chapter19.common.patternMatch;

import chapter19._4_pattern_matching.common.BinOp;
import chapter19._4_pattern_matching.common.Expr;
import chapter19._4_pattern_matching.common.Number;
import chapter9._2_refactoring_designPattern.factory.common.TriFunction;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Match<T> {

    public static void main(String[] args) {
        Expr e = new BinOp("+", new Number(1), new Number(2));
        String binopcode = "binop";
        String numcode = "num";
        String defaultcode = "default";

        patternMatchExpr(e, (op, l, r) -> binopcode,
                            (n) -> numcode,
                            () -> defaultcode);

        Expr e2 = new BinOp("*", new Number(1), new Number(2));
        Expr match = simplify(e2);
        System.out.println(match);
    }

    public static Expr simplify(Expr e) {
        TriFunction<String, Expr, Expr, Expr> binocase =
                (opname, left, right) -> {
                    if (opname.equals("+")) {
                        if (left instanceof Number && ((Number) left).getVal() == 0) {
                            return right;
                        } else if (right instanceof Number && ((Number) right).getVal() == 0) {
                            return left;
                        }
                    } else if (opname.equals("*")) {
                        if (left instanceof Number && ((Number) left).getVal() == 1) {
                            return right;
                        }
                        if (right instanceof Number && ((Number) right).getVal() == 1) {
                            return left;
                        }
                    }
                    return new BinOp(opname, left, right);
        };

        Function<Integer, Expr> numcase = (n) -> new Number(n);
        Supplier<Expr> defaultcase = () -> new Number(0);

        return patternMatchExpr(e, binocase, numcase, defaultcase);
    }

    public static <T> T patternMatchExpr(
        Expr e,
        TriFunction<String, Expr, Expr, T> binocase,
        Function<Integer, T> numcase,
        Supplier<T> defaultcase
    ) {
        return (e instanceof BinOp) ?
                binocase.apply(((BinOp)e).getOpname(), ((BinOp)e).getLeft(),
                                                       ((BinOp)e).getRight()) :
               (e instanceof Number) ?
                numcase.apply(((Number)e).getVal()) :
                defaultcase.get();
    }

    public static <T> T myIf(boolean b, Supplier<T> truecase, Supplier<T> falsecase) {
        return b ? truecase.get() : falsecase.get();
    }
}
