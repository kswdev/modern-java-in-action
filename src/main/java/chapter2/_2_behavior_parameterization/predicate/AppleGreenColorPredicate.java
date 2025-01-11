package chapter2._2_behavior_parameterization.predicate;

import common.apple.Apple;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeightValue() > 150;
    }
}
