package chapter13._1_changing_api.v2.diagram;

import chapter13._1_changing_api.v2.diagram.option.movable.Moveable;
import chapter13._1_changing_api.v2.diagram.option.resizable.Resizable;
import chapter13._1_changing_api.v2.diagram.option.rotatable.Rotatable;

public class Monster implements Rotatable, Moveable, Resizable {
    private int x;
    private int y;
    private int width;
    private int height;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }

    @Override
    public void setRotationAngle(int angleInDegrees) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }
}
