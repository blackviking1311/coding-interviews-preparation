package org.example.datastructures.linkedlist.medium;

import org.example.datastructures.linkedlist.logicbuilding.ListNode;

public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode delNode = slow.next;
        slow.next = delNode.next;

        return head;
    }
}
