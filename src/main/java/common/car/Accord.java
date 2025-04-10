package common.car;

public class Accord implements Car {

    private final Brand brand = Brand.HONDA;
    private final Color color;

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
    public String toString() {
        return "Accord";
    }
}
