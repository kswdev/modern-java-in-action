package chapter15._5_pub_sub_reactive.cell;

public class ArithmeticalCell extends SimpleCell{
    private int left;
    private int right;

    public ArithmeticalCell(String name) {
        super(name);
    }

    public void setLeft(int left) {
        this.left = left;
        onNext(left + this.right);
    }

    public void setRight(int right) {
        this.right = right;
        onNext(this.left + right);
    }
}
