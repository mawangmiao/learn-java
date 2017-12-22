package com.example.linkedlist;

public class LinkedListReverseTest {

    public static void main(String[] args) {
        System.out.println(reverse(null));
        System.out.println("----------------");
        LinkedListNode head = new LinkedListNode(1);
        LinkedListPrinter.print(reverse(head));
        System.out.println("----------------");
        head = LinkedListNode.from(new int[]{1, 7});
        LinkedListPrinter.print(reverse(head));
        System.out.println("----------------");
        head = LinkedListNode.from(new int[]{1, 3, 5, 7});
        LinkedListPrinter.print(reverse(head));
    }


    private static LinkedListNode reverse(LinkedListNode head) {
        if (head == null) {
            return null;
        } else if (head.getNext() == null) {
            return head;
        }

        LinkedListNode previous = null;
        LinkedListNode current = head;
        LinkedListNode next;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        return previous;
    }

}

