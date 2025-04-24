package chapter13._1_changing_api.v1;

import chapter13._1_changing_api.v1.resizable.Ellipse;
import chapter13._1_changing_api.v1.resizable.Rectangle;
import chapter13._1_changing_api.v1.resizable.Resizable;
import chapter13._1_changing_api.v1.resizable.Square;
import chapter13._1_changing_api.v1.util.Utils;

import java.util.Arrays;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        List<Resizable> resizableShapes =
                Arrays.asList(new Square(), new Rectangle(), new Ellipse());
        Utils.paint(resizableShapes);
    }
}
