package org.example.datastructures.linkedlist.medium;

import org.example.datastructures.linkedlist.logicbuilding.ListNode;

public class FindIntersectionLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) return null;

        ListNode ptr1 = headA, ptr2 = headB;

        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

            if (ptr1 == ptr2) return ptr1;

            if (ptr1 == null) ptr1 = headB;
            if (ptr2 == null) ptr2 = headA;
        }

        return ptr1;
    }

    public static void main(String[] args) {

    }
}
