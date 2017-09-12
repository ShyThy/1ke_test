package com.java.thy;

import java.lang.annotation.*;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-29
 */
public class RepeatingAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters{
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter{
        String value();
    }

    @Filter(value = "filter1")
    @Filter(value = "filter2")
    public interface Filterable{
    }

    public static void main(String args[]){
        for (Filter filter: Filterable.class.getAnnotationsByType(Filter.class)){
            System.err.println("result: " + filter.value());
        }
    }
}
