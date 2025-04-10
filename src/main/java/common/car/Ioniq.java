package common.car;

import common.insurance.Insurance;

public class Ioniq implements Car {

    private final Brand brand = Brand.HYUNDAI;
    private final Color color;
    private Insurance insurance;

    public Ioniq(Color color) {
        this.color = color;
    }

    @Override
    public Brand getBrand() {
        System.out.println("brand");
        return this.brand;
    }

    @Override
    public Color getColor() {
        System.out.println("color");
        return this.color;
    }

    @Override
    public Insurance getInsurance(){ return insurance; }

    @Override
    public String toString() {
        return "Ioniq";
    }
}
