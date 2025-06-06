package chapter19._4_pattern_matching.common;

public class Number extends Expr {
    private int val;
    public Number(int val) { this.val = val; }
    public int getVal() { return val; }

    @Override
    public String toString() {
        return "Number{" +
                "val=" + val +
                '}';
    }
}
