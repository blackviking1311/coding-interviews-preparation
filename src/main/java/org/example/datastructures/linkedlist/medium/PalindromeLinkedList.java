package org.example.datastructures.linkedlist.medium;

import org.example.datastructures.linkedlist.logicbuilding.ListNode;

public class PalindromeLinkedList {

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    /**
     * Function to check if the given linked list is palindrome or not
     * @param head head of the linked list
     * @return true if the given linked list is palindrome otherwise returns false
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = this.reverseLinkedList(slow.next);
        ListNode ptr1 = head, ptr2 = reversed;

        while (ptr2 != null) {
            if (ptr1.data != ptr2.data) {
                return false;
            }
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }

        return true;
    }

    //  driver code / main function for the program
    public static void main(String[] args) {
        //  initializing the object of the class 1 => 2 => 2 => 1
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode head = null, tail = null;
        int[] arr = {1,1,2,1};

        for (int el : arr) {
            ListNode dataNode = new ListNode(el);
            if (head == null) {
                head = dataNode;
            } else {
                tail.next = dataNode;
            }
            tail = dataNode;
        }

        System.out.println(palindromeLinkedList.isPalindrome(head));
    }
}
