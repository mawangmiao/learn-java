package com.example.algorithm;

public class NOneCountTest {

    public static void main(String[] args) {
        System.out.println("1: [" + simpleCount(1) + "," + efficientCount(1) + "]");
        System.out.println("12: [" + simpleCount(12) + "," + efficientCount(12) + "]");
    }

    private static int simpleCount(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += simpleCountInternal(i);
        }
        return count;
    }

    private static int simpleCountInternal(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 1) {
                count++;
            }
            n = n / 10;
        }
        return count;
    }

    private static int efficientCount(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 9) {
            return 1;
        } else {
            String strN = String.valueOf(n);
            int firstNumber = Integer.valueOf(strN.substring(0, 1));
            int otherNumber = Integer.valueOf(strN.substring(1, strN.length()));
            int first = firstNumber > 1 ? (int) Math.pow(10, strN.length() - 1) : otherNumber;
            int second = (firstNumber - 1) * efficientCount(10 * (strN.length() - 1) - 1);
            int third = efficientCount(otherNumber);
            return first + second + third;
        }
    }

}
