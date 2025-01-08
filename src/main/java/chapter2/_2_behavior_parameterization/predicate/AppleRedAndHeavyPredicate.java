package chapter2._2_behavior_parameterization.predicate;

import chapter2.common.Apple;
import chapter2.common.Color;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
