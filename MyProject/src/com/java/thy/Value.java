package com.java.thy;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-29
 */
public class Value<T> {
    public static <T> T defaultValue(){
        return null;
    }

    public T getOrDefault(T value, T defaultValue){
        return (null != value)? value : defaultValue;
    }

    public static void main(String args[]){
        final Value<String> v = new Value<String>();
        String r = v.getOrDefault("22", Value.defaultValue());
        System.err.println(r);
    }
}
