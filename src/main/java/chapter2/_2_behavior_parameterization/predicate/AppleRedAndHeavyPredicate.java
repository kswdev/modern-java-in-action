package chapter2._2_behavior_parameterization.predicate;

import common.apple.Apple;
import common.apple.Color;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
