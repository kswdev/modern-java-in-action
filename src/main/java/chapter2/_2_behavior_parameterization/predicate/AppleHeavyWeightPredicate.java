package chapter2._2_behavior_parameterization.predicate;

import chapter2.common.Apple;
import chapter2.common.Color;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}
