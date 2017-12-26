package com.example.linkedlist;

import org.apache.commons.lang3.Validate;

public class CircularLinkedListTest {

    public static void main(String[] args) {
        LinkedListNode head = CircularLinkedList.init(null);
        LinkedListPrinter.print(head);
        getLastAfterDelete(head, 3);

        head = CircularLinkedList.init(new int[0]);
        LinkedListPrinter.print(head);
        getLastAfterDelete(head, 3);

        head = CircularLinkedList.init(new int[]{1});
        LinkedListPrinter.print(head);
        getLastAfterDelete(head, 3);

        head = CircularLinkedList.init(new int[]{1, 4});
        LinkedListPrinter.print(head);
        getLastAfterDelete(head, 2);

        head = CircularLinkedList.init(new int[]{0, 1, 2, 3, 4});
        LinkedListPrinter.print(head);
        getLastAfterDelete(head, 3);

        head = CircularLinkedList.init(new int[]{0, 1, 2, 3, 4});
        LinkedListPrinter.print(head);
        getLastAfterDelete(head, 2);

        head = CircularLinkedList.init(new int[]{0, 1, 2, 3, 4});
        LinkedListPrinter.print(head);
        getLastAfterDelete(head, 5);

        head = CircularLinkedList.init(new int[]{0, 1, 2, 3, 4});
        LinkedListPrinter.print(head);
        getLastAfterDelete(head, 6);
    }

    private static LinkedListNode getLastAfterDelete(LinkedListNode head, int m) {
        if (head == null || head.getNext() == null) return head;

        Validate.isTrue(m > 1, "m必须大于1");
        int n = m;
        while (n > 0 && head.getNext() != head) {
            n--;
            if (n == 1) {
                //删除next
                System.out.println("删除" + head.getNext().getValue());
                head.setNext(head.getNext().getNext());
                //重置n
                n = m;
                System.out.print("删除后当前链表");
                LinkedListPrinter.print(head.getNext());
            }
            head = head.getNext();
        }
        System.out.println("每次删除第" + m + "个数字后剩下" + head.getValue());
        System.out.println();
        return head;
    }
}

