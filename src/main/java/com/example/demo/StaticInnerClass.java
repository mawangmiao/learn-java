package com.example.demo;

public class StaticInnerClass {

    static class one {
        private static class two {
            public static void main(String[] args) {
                System.out.println("two");
            }
        }
    }
}
