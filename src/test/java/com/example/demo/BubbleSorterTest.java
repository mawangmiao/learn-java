package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSorterTest {

    @Test
    public void sort() throws Exception {
        assertArrayEquals(BubbleSorter.sort(new int[]{}), new int[]{});
        assertArrayEquals(BubbleSorter.sort(new int[]{3}), new int[]{3});
        assertArrayEquals(BubbleSorter.sort(new int[]{4, 3}), new int[]{3, 4});
        assertArrayEquals(BubbleSorter.sort(new int[]{3, 2, 1}), new int[]{1, 2, 3});
    }
}