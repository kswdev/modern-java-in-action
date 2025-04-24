package chapter13._1_changing_api.v1.resizable;

import chapter13.common.Drawble;

public interface Resizable extends Drawble {
    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);
    void setAbsoluteSize(int width, int height);
}
