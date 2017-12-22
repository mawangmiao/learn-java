package com.example.demo;

class BubbleSorter {

    synchronized static int[] sort(int[] a) {
        boolean sortedAtLeastOnce;
        do {
            sortedAtLeastOnce = false;
            for (int i = 0; i < a.length - 1; i++) {
                int current = a[i];
                int next = a[i + 1];
                if (current > next) {
                    a[i + 1] = current;
                    a[i] = next;
                    sortedAtLeastOnce = true;
                }
            }
        } while (sortedAtLeastOnce);
        return a;
    }
}
