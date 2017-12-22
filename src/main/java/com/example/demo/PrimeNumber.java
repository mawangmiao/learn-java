package com.example.demo;

public class PrimeNumber {

    public static void main(String[] args) {
        final int n = 101;
        final int max = (int) Math.sqrt(n);
        System.out.println(max);

        int[] arr = new int[n];
        for (int i = 2; i <= max; i++) {
            if (arr[i] == -1) continue;
            for (int j = i + 1; j < n; j++) {
                if (j % i == 0) arr[j] = -1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] == 0) System.out.print(i + ",");
        }
    }

}
