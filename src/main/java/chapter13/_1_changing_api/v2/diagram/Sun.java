package chapter13._1_changing_api.v2.diagram;

import chapter13._1_changing_api.v1.resizable.Resizable;
import chapter13._1_changing_api.v2.diagram.option.rotatable.Rotatable;

public class Sun implements Rotatable, Resizable {

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

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
