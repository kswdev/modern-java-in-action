package chapter19._2_persistence_data_structure;

import chapter19.common.TrainJourney;

public class Main {

    public static void main(String[] args) {


    }

    // 함수형으로 바꾼 코드
    private static TrainJourney append(TrainJourney a, TrainJourney b) {
        return a == null ? b : new TrainJourney(a.price, append(a.onward, b));
    }

    // 단순한 명령형 메서드
    private static TrainJourney link (TrainJourney a,  TrainJourney b) {
        if (a == null) return b;
        TrainJourney t = a;
        while (t.onward != null) {
            t = t.onward;
        }
        t.onward = b;
        return a;
    }
}
