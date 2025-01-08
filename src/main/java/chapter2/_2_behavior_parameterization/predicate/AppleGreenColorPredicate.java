package chapter2._2_behavior_parameterization.predicate;

import chapter2.common.Apple;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
