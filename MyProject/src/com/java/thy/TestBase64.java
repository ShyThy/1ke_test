package com.java.thy;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-30
 */
public class TestBase64 {
    public static void main(String args[]){
        final String text = "Base64 finally in java8 !!!";
        final String encode = Base64
                .getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.err.println("encode : " + encode);

//        final String decode = Base64
//                .getDecoder()
//                .decode(encode).toString();
        final String decode = new String(Base64.getDecoder().decode(encode), StandardCharsets.UTF_8);
        System.err.println("decode : " + decode);

    }
}
