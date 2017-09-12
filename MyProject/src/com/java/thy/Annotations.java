package com.java.thy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-29
 */
public class Annotations {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
//    @Target(ElementType.TYPE)
    public @interface NonEmpty{
    }

    public static class Holder<@NonEmpty T> extends @NonEmpty Object{
        public void method() throws @NonEmpty Exception{
            System.err.println("err err err !!!");
            System.err.println("err err err !!!");
            System.err.println("err err err !!!");
        }
    }

    public static void main(String args[]) throws Exception {
        final Holder<@NonEmpty String> holder = new @NonEmpty Holder<String>();
        holder.method();
        @NonEmpty Collection<@NonEmpty String> strs = new ArrayList<>();
    }
}
