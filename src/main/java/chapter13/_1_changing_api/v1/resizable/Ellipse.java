package chapter13._1_changing_api.v1.resizable;

public class Ellipse implements Resizable {

    private int width;
    private int height;

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
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
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {

    }
}
