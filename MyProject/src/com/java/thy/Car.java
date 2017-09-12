package com.java.thy;

import java.util.function.Supplier;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-29
 */
public class Car {
    public static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }

    public static void collide(final Car car){
        System.err.println("Collide : " + car.toString());
    }

    public void follow(final Car car){
        System.err.println("Follow : " + car.toString());
    }

    public void repair(){
        System.err.println("Repair : " + this.toString());
    }
}
