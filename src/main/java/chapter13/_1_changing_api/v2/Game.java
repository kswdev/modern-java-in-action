package chapter13._1_changing_api.v2;

import chapter13._1_changing_api.v2.diagram.Ellipse;
import chapter13._1_changing_api.v2.diagram.Monster;
import chapter13._1_changing_api.v2.diagram.Rectangle;
import chapter13._1_changing_api.v2.diagram.option.resizable.Resizable;
import chapter13._1_changing_api.v2.diagram.Square;
import chapter13._1_changing_api.v2.util.Utils;

import java.util.Arrays;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        List<Resizable> resizableShapes =
                Arrays.asList(new Square(), new Rectangle(), new Ellipse());
        Utils.paint(resizableShapes);

        Monster monster = new Monster();
        monster.rotateBy(180);
        monster.moveVertically(10);
    }
}
