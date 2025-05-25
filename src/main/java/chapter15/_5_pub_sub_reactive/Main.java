package chapter15._5_pub_sub_reactive;

import chapter15._5_pub_sub_reactive.cell.ArithmeticalCell;
import chapter15._5_pub_sub_reactive.cell.SimpleCell;

public class Main {

    public static void main(String[] args) {
        SimpleCell c1 = new SimpleCell("C1");
        SimpleCell c2 = new SimpleCell("C2");
        ArithmeticalCell c3 = new ArithmeticalCell("C3");

        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);

        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(30);
    }
}
