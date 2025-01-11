package common.apple;

public class Apple {

    private final Color color;
    private final Weight weight;

    public Apple(Color color, int value) {
        this.color = color;
        this.weight = new Weight(value);
    }

    public int getWeightValue() {
        return weight.getValue();
    }

    public Weight getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }
}
