package chapter11._1_reduce_null_point_exception;

import common.car.Car;
import common.insurance.Insurance;
import common.person.Person;

public class Null_safe {

    public static void main(String[] args) {


    }

    // 1. 깊은 의심
    public String getInsuranceName(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    // 2. 너무 많은 출구
    public String getInsuranceName2(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }
}
