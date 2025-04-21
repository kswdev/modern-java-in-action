package chapter11.common.car;


import chapter11.common.Insurance;

import java.util.Optional;

public class Kona implements Car {

    private final Brand brand = Brand.HYUNDAI;
    private final Color color;
    private Optional<Insurance> insurance;

    public Kona(Color color) { this.color = color; }

    @Override
    public Brand getBrand() { return this.brand; }

    @Override
    public Color getColor() { return this.color; }

    @Override
    public Optional<Insurance> getInsurance(){ return insurance; }

    @Override
    public String toString() { return "Kona"; }
}
