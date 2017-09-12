package com.java.thy;

import java.util.Optional;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-30
 */
public class TestOptionals {

    public static void main(String args[]){
        test1();
    }

    private static void test1(){
//        Optional<String> firstName = Optional.ofNullable(null);
        Optional<String> firstName = Optional.ofNullable("ttttt");
        System.err.println("Full name is set? " + firstName.isPresent());
        System.err.println("Full name : " + firstName.orElseGet(() -> "[none]"));
        System.err.println(firstName.map( s -> "Hey " + s + " !!!").orElse("Hey Stranger!"));
    }
}
