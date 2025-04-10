package common.car;

import common.insurance.Insurance;

public interface Car {
    Brand getBrand();
    Color getColor();
    Insurance getInsurance();
}
