package chapter10._2_java8_smallest_DSL.common.car;

public class Ioniq implements Car {

    private final Brand brand = Brand.HYUNDAI;
    private final Color color;

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
    public String toString() {
        return "Ioniq";
    }
}
