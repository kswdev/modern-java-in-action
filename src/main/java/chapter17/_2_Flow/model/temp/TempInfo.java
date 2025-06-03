package chapter17._2_Flow.model.temp;

import java.util.Random;

public class TempInfo {

    public static final Random random = new Random();

    private final String town;
    private final int temp;

    public TempInfo(String town, int temp) {
        this.town = town;
        this.temp = temp;
    }

    // 정적 팩토리 메서드를 이용해 해당 도시의 tempInfo 인스턴스를 만든다.
    public static TempInfo fetch(String town) {
        return new TempInfo(town, random.nextInt(100));
    }

    @Override
    public String toString() {
        return town + " : " + temp;
    }

    public String getTown() {
        return town;
    }

    public int getTemp() {
        return temp;
    }
}
