package com.example.demo;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.print(fibonacciRecurse(1) + " ");
        System.out.print(fibonacciRecurse(2) + " ");
        System.out.print(fibonacciRecurse(3) + " ");
        System.out.print(fibonacciRecurse(4) + " ");
        System.out.print(fibonacciRecurse(5) + " ");
        System.out.print(fibonacciRecurse(6) + " ");
        System.out.println(fibonacciRecurse(7));

        System.out.print(fibonacciLoop(1) + " ");
        System.out.print(fibonacciLoop(2) + " ");
        System.out.print(fibonacciLoop(3) + " ");
        System.out.print(fibonacciLoop(4) + " ");
        System.out.print(fibonacciLoop(5) + " ");
        System.out.print(fibonacciLoop(6) + " ");
        System.out.println(fibonacciLoop(7));
    }

    static int fibonacciRecurse(int n) {
        if (n <= 2) return 1;

        return fibonacciRecurse(n - 1) + fibonacciRecurse(n - 2);
    }

    static int fibonacciLoop(int n) {
        if (n <= 2) return 1;

        int previousPreviousResult = 1;
        int previousResult = 1;
        int currentResult = 0;

        int i = 3;
        while (i <= n) {
            currentResult = previousPreviousResult + previousResult;
            previousPreviousResult = previousResult;
            previousResult = currentResult;
            i++;
        }
        return currentResult;
    }
}
