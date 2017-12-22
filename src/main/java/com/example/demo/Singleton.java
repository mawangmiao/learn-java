package com.example.demo;

public class Singleton {

    private Singleton() {}

    public static Singleton getInstance() {
        return InnerSingleton.INSTANCE;
    }

    public void sayHello(){
        System.out.println("hello");
    }

    private static class InnerSingleton {
        private static final Singleton INSTANCE = new Singleton();
    }
}
