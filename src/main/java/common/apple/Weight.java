package common.apple;

public class Weight implements Comparable<Weight>{

    private final int value;

    protected int getValue() {
        return value;
    }

    public Weight(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Weight o) {
        return this.getValue() - o.getValue();
    }
}
