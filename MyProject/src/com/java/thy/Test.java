package com.java.thy;

import java.util.Arrays;
import java.util.List;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-29
 */
public class Test {
    public static void main(String args[]){
        System.err.println("tttt");
        testLambda();
    }

    private static String yes = "yes";

    private static void testLambda(){
        String no = "no";
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(e -> System.err.println(e));
        System.err.println("---------------");
        for (String s :list) {
            System.err.println(s);
        }
        System.err.println("---------------");
        Arrays.asList("c", "b", "a").forEach((String e) -> {
            System.err.println(e + yes);
            System.err.println(e + no);
        });

        list.sort((e1, e2) -> e1.compareTo(e2));
        list.sort((e1, e2) -> {
            System.err.println("e1:" + e1);
            System.err.println("e2:" + e2);
            int r = e1.compareTo(e2);
            System.err.println("r: " + r);
            return r;
        });
        System.err.println(list.get(0));
    }
}
