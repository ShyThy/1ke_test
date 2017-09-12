package com.java.thy;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-30
 */
public class TestParallelArrays {
    public static void main(String args[]){
        long[] arrayOfLong = new long[200000];

        System.err.println(ThreadLocalRandom.current().nextInt(1000000));
        System.err.println(ThreadLocalRandom.current());
        System.err.println();
        Arrays.parallelSetAll(arrayOfLong, index ->
                    ThreadLocalRandom.current().nextInt(1000000)
                );
        Arrays.stream(arrayOfLong).limit(100).forEach(
                i -> System.err.print(i + "   ")
        );
        System.err.println("");

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(100).forEach(
                i -> System.err.print(i + "    ")
        );
//        Arrays.parallel;
    }
}
