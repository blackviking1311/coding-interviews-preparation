package org.example.datastructures.linkedlist.logicbuilding;

public class LinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }

        odd.next = evenHead;
        return head;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode zeroHead = new ListNode(-1), oneHead = new ListNode(-1), twoHead = new ListNode(-1);
        ListNode zeroTail = zeroHead, oneTail = oneHead, twoTail = twoHead;

        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.data == 0) {
                zeroTail.next = ptr;
                zeroTail = ptr;
            } else if (ptr.data == 1) {
                oneTail.next = ptr;
                oneTail = ptr;
            } else if (ptr.data == 2) {
                twoTail.next = ptr;
                twoTail = ptr;
            }

            ptr = ptr.next;
        }

        zeroTail.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        oneTail.next = twoHead.next;
        twoTail.next = null;

        return zeroHead.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;

        for (int i = 0 ; i < n ; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode delNode = slow.next;
        slow.next = slow.next.next;

        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, curr = head, next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next != null ? next.next : null;
        }

        return prev;
    }

    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseListRecursion(head.next);
        ListNode frontNode = head.next;
        frontNode.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        ListNode head = null, tail = null;
        int[] arr = {1,2,3,4,5};
        for (int el : arr) {
            System.out.print(el + " : ");
        }
        System.out.println();

        for (int el : arr) {
            ListNode newNode = new ListNode(el);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }

        for (ListNode ptr = linkedList.reverseList(head) ; ptr != null ; ptr = ptr.next) {
            System.out.print(ptr.data + " : ");
        }
    }
}
