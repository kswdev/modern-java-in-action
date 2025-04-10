package common.car;

import common.insurance.Insurance;

public class Kona implements Car {

    private final Brand brand = Brand.HYUNDAI;
    private final Color color;
    private Insurance insurance;

    public Kona(Color color) { this.color = color; }

    @Override
    public Brand getBrand() { return this.brand; }

    @Override
    public Color getColor() { return this.color; }

    @Override
    public Insurance getInsurance(){ return insurance; }

    @Override
    public String toString() { return "Kona"; }
}
