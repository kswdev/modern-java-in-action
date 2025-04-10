package common.car;

import common.insurance.Insurance;

public class Accord implements Car {

    private final Brand brand = Brand.HONDA;
    private final Color color;
    private Insurance insurance;

    public Accord(Color color) {
        this.color = color;
    }

    @Override
    public Brand getBrand() {
        return this.brand;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Insurance getInsurance() {
        return this.insurance;
    }

    @Override
    public String toString() {
        return "Accord";
    }
}
