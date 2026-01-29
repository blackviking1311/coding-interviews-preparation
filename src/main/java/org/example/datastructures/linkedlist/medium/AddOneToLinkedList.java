package org.example.datastructures.linkedlist.medium;

import org.example.datastructures.ListNode;

public class AddOneToLinkedList {
    
    private int addOneHelper(ListNode head) {
        if (head == null) {
            return 1;
        }

        int carry = addOneHelper(head.next);
        head.data += 1;

        if (head.data < 10)
            return 0;

        head.data = 0;
        return 1;
    }

    public ListNode addOne(ListNode head) {
        int carry = addOneHelper(head);

        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
