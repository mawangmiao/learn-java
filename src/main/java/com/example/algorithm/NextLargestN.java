package com.example.algorithm;

public class NextLargestN {

    public static void main(String[] a) {
        int totalCount = 1;
        int n = 2;
        while ((totalCount += getCountForCurrentNumberOnly(n)) != n) {
            n++;
        }
        System.out.println(n + "," + totalCount);
    }


    static int getCountForCurrentNumberOnly(int n) {

        char[] charArray = String.valueOf(n).toCharArray();
        int count = 0;
        for (char c : charArray) {
            if (c == '1') count++;
        }
        return count;
    }
}
