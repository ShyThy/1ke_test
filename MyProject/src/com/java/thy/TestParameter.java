package com.java.thy;

import sun.plugin2.util.ParameterNames;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-30
 */
public class TestParameter {
    public static void main(String args[]) throws NoSuchMethodException {
        Method method = ParameterNames.class.getMethod("main", String[].class);
        for (final Parameter parameter: method.getParameters()){
            System.err.println("Parameters : " + parameter.getName());
            System.err.println("Parameters : " + parameter.getType());
        }
    }
}
