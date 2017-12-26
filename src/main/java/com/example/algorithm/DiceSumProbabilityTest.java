package com.example.algorithm;

import java.util.HashMap;
import java.util.Map;

class DiceSumProbabilityTest {

    public static void main(String[] args) {
        Map<Integer, Integer> sumProbabilities = getSumProbabilities(1);
        System.out.println("-------一个色子-------");
        sumProbabilities.forEach((k, v) -> System.out.println("和" + k + "的次数为" + v));

        sumProbabilities = getSumProbabilities(2);
        System.out.println("-------两个色子-------");
        sumProbabilities.forEach((k, v) -> System.out.println("和" + k + "的次数为" + v));

        sumProbabilities = getSumProbabilities(3);
        System.out.println("-------三个色子-------");
        sumProbabilities.forEach((k, v) -> System.out.println("和" + k + "的次数为" + v));

        System.out.println("-------10个色子-------");
        long startTime = System.currentTimeMillis();
        sumProbabilities = getSumProbabilities(10);
        long timeInMillis = System.currentTimeMillis() - startTime;
        System.out.println("耗时" + timeInMillis);
        sumProbabilities.forEach((k, v) -> System.out.println("和" + k + "的次数为" + v));

        System.out.println("-------100个色子-------");
        startTime = System.currentTimeMillis();
        sumProbabilities = getSumProbabilities(100);
        timeInMillis = System.currentTimeMillis() - startTime;
        System.out.println("耗时" + timeInMillis);
//        sumProbabilities.forEach((k, v) -> System.out.println("和" + k + "的次数为" + v));

        System.out.println("-------1000个色子-------");
        startTime = System.currentTimeMillis();
        sumProbabilities = getSumProbabilities(1000);
        timeInMillis = System.currentTimeMillis() - startTime;
        System.out.println("耗时" + timeInMillis);
//        sumProbabilities.forEach((k, v) -> System.out.println("和" + k + "的次数为" + v));

        System.out.println("-------10000个色子-------");
        startTime = System.currentTimeMillis();
        sumProbabilities = getSumProbabilities(10000);
        timeInMillis = System.currentTimeMillis() - startTime;
        System.out.println("耗时" + timeInMillis / 1000 + "秒");
    }

    private static Map<Integer, Integer> getSumProbabilities(int diceNumber) {
        if (diceNumber < 1) return null;

        Map<Integer, Integer> previousProbabilities = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            previousProbabilities.put(i, 1);
        }
        if (diceNumber == 1) return previousProbabilities;


        int n = 2;
        while (n <= diceNumber) {
            Map<Integer, Integer> currentProbabilities = new HashMap<>();
            int minSum = n;
            int maxSum = n * 6;

            for (int sum = minSum; sum <= maxSum; sum++) {
                int probability = 0;
                for (int i = 1; i <= 6; i++) {
                    probability += previousProbabilities.getOrDefault(sum - i, 0);
                }
                currentProbabilities.put(sum, probability);
            }
            n++;

            previousProbabilities = currentProbabilities;
        }

        return previousProbabilities;
    }
}
