package chapter17.common;

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

        // 1/10 확률로 실패
        if (random.nextInt(10) == 0)
            throw new RuntimeException("Error fetching temp info for " + town);
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
