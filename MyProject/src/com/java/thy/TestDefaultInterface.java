package com.java.thy;

import java.util.function.Supplier;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-29
 */
public class TestDefaultInterface {
    public static void main(String args[]){
        Defautable defautable = DefautableFactory.create(DefautableImpl::new);
        System.err.println(defautable.notRequired());
        System.err.println("-----------------------");
        Defautable overridable = DefautableFactory.create(OverridableImpl::new);
        System.err.println(overridable.notRequired());

//        Defautable t = new OverridableImpl();
//        Defautable tt = DefautableFactory.create((Supplier<Defautable>) t);
//        System.err.println(tt.notRequired());
    }
}
