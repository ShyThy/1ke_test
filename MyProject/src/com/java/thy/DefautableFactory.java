package com.java.thy;

import java.util.function.Supplier;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-29
 */
public interface DefautableFactory {
    static Defautable create(Supplier<Defautable> supplier){
        return supplier.get();
    }
}
