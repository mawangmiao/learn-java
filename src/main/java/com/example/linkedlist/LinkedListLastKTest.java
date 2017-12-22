package com.example.linkedlist;

public class LinkedListLastKTest {

    public static void main(String[] args) {
        System.out.println(lastK(null, 1));
        System.out.println("----------------");
        LinkedListNode head = new LinkedListNode(1);
        System.out.println(lastK(head, 0));
        System.out.println(lastK(head, 1).getValue());
        System.out.println(lastK(head, 2));
        System.out.println("----------------");
        head = LinkedListNode.from(new int[]{1, 3, 5, 7});
        System.out.println(lastK(head, 1).getValue());
        System.out.println(lastK(head, 3).getValue());
        System.out.println(lastK(head, 4).getValue());
        System.out.println(lastK(head, 5));
    }


    private static LinkedListNode lastK(LinkedListNode head, int k) {
        if (head == null || k <= 0) return null;

        LinkedListNode first = head;
        for (int i = 0; i < k - 1; i++) {
            if (first.getNext() != null) {
                first = first.getNext();
            } else {
                return null;
            }
        }

        LinkedListNode second = head;
        while (first.getNext() != null) {
            first = first.getNext();
            second = second.getNext();
        }

        return second;
    }

}

