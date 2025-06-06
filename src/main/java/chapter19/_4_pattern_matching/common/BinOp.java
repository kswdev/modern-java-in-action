package chapter19._4_pattern_matching.common;

public class BinOp extends Expr {
    private String opname;
    private Expr left, right;
    public BinOp(String opname, Expr left, Expr right) {
        this.opname = opname;
        this.left = left;
        this.right = right;
    }

    public Expr accept(SimplifyVisitor v) {
        return v.visit(this);
    }
    public String getOpname() { return opname; }
    public Expr getLeft() { return left; }
    public Expr getRight() { return right; }

    @Override
    public String toString() {
        return "BinOp{" +
                "opname='" + opname + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
