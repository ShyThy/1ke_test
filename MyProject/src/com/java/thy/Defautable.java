package com.java.thy;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-29
 */

public interface Defautable {
    default String notRequired(){
        return "Default implementation!!!";
    }
}
