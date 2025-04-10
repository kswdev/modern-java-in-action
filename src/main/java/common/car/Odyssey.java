package common.car;

public class Odyssey implements Car {

    private final Brand brand = Brand.HONDA;
    private final Color color;

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
    public String toString() {
        return "Odyssey";
    }
}
