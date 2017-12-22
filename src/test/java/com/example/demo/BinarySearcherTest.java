package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearcherTest {
    @Test
    public void search() throws Exception {
        assertEquals(BinarySearcher.search(new int[]{}, 123), -1);
        assertEquals(BinarySearcher.search(new int[]{123}, 123), 0);
        assertEquals(BinarySearcher.search(new int[]{123}, 456), -1);
        assertEquals(BinarySearcher.search(new int[]{123, 456}, 456), 1);
        assertEquals(BinarySearcher.search(new int[]{123, 456}, 789), -1);
        assertEquals(BinarySearcher.search(new int[]{123, 456, 789}, -0), -1);
        assertEquals(BinarySearcher.search(new int[]{123, 456, 789}, 456), 1);
        assertEquals(BinarySearcher.search(new int[]{123, 456, 789}, 789), 2);
    }
}