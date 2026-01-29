package org.example.datastructures.linkedlist.medium;

import org.example.datastructures.linkedlist.logicbuilding.ListNode;

public class FindStartingPosition {

    public ListNode findStartingPoint(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public int findLengthOfLoop(ListNode head) {
        ListNode startingPoint = this.findStartingPoint(head);
        if (startingPoint == null) return 0;

        ListNode ptr = startingPoint.next;
        int count = 1;

        while (ptr != startingPoint) {
            count++;
            ptr = ptr.next;
        }

        return count;
    }
}
