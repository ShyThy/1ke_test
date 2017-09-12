package com.java.thy;

import java.util.Arrays;
import java.util.List;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-29
 */
public class TestCar {
    public static void main(String args[]){
        final Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);

        cars.forEach(car::follow);

        cars.forEach(Car::collide);
        cars.forEach(Car::repair);

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
