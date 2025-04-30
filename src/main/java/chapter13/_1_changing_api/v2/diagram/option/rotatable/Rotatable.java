package chapter13._1_changing_api.v2.diagram.option.rotatable;

public interface Rotatable {

    void setRotationAngle(int angleInDegrees);
    int getRotationAngle();
    default void rotateBy(int angleInDegrees) {
        setRotationAngle(getRotationAngle() + angleInDegrees % 360);
    }
}
