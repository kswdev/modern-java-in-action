package common.car;

public class Kona implements Car {

    private final Brand brand = Brand.HYUNDAI;
    private final Color color;

    public Kona(Color color) {
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
    public String toString() {
        return "Kona";
    }
}
