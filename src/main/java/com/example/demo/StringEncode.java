package com.example.demo;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringEncode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "01彭";
        System.out.println("默认(使用UTF-8)     :" + Arrays.toString(str.getBytes()));
        System.out.println("UTF-8              :" + Arrays.toString(str.getBytes("UTF-8")));
        System.out.println("UTF-16             :" + Arrays.toString(str.getBytes("UTF-16")));
        System.out.println("Unicode(使用UTF-16) :" + Arrays.toString(str.getBytes("Unicode")));
        System.out.println("GBK                :" + Arrays.toString(str.getBytes("GBK")));
        char c = '彭';
        System.out.println((short) c);
        c = '0';
        System.out.println((short) c);
        System.out.println();
        System.out.println(new String(str.getBytes("GBK"), "UTF-8"));
        System.out.println(new String(str.getBytes("GBK"), "GBK"));
    }
}
