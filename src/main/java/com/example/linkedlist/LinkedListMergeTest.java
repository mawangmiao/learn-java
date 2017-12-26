package com.example.linkedlist;

public class LinkedListMergeTest {

    public static void main(String[] args) {
        System.out.println(LinkedList.init(null));
        System.out.println(LinkedList.init(new int[0]));
        LinkedListPrinter.print(LinkedList.init(new int[]{1}));

        LinkedListNode firstHead = LinkedList.init(new int[]{1, 3, 5, 7});
        LinkedListNode secondHead = LinkedList.init(new int[]{1, 4, 5, 6, 8});
        LinkedListPrinter.print(merge(firstHead, secondHead));
        System.out.println(merge(null, null));
    }

    private static LinkedListNode merge(LinkedListNode firstHead, LinkedListNode secondHead) {
        if (firstHead == null) {
            return secondHead;
        } else if (secondHead == null) {
            return firstHead;
        }

        LinkedListNode current;
        if (firstHead.getValue() < secondHead.getValue()) {
            current = firstHead;
            current.setNext(merge(firstHead.getNext(), secondHead));
        } else {
            current = secondHead;
            current.setNext(merge(firstHead, secondHead.getNext()));
        }
        return current;
    }
}

