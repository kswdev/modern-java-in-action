package common.apple;

public class Apple implements Comparable<Apple> {

    private final Color color;
    private final int weight;

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int compareTo(Apple o) {
        return this.getWeight() - o.getWeight();
    }
}
