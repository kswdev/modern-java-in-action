package chapter11.common.car;


import chapter11.common.Insurance;

import java.util.Optional;

public interface Car {
    Brand getBrand();
    Color getColor();
    Optional<Insurance> getInsurance();
}
