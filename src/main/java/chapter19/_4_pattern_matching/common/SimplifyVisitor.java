package chapter19._4_pattern_matching.common;

public class SimplifyVisitor {

    public Expr visit(BinOp e) {
        if ("+".equals(e.getOpname()) && e.getRight() instanceof Number /* && ... */) {
            return e.getLeft();
        }
        return e;
    }
}
