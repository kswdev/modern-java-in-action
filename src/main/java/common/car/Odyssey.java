package common.car;

import common.insurance.Insurance;

public class Odyssey implements Car {

    private final Brand brand = Brand.HONDA;
    private final Color color;
    private Insurance insurance;

    public Odyssey(Color color) {
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
    public Insurance getInsurance(){ return insurance; }

    @Override
    public String toString() {
        return "Odyssey";
    }
}
