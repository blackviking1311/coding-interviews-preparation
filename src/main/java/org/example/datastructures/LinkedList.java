package org.example.datastructures;

public class LinkedList {
    private ListNode head, tail;

    public LinkedList() {
        this.head = this.tail = null;
    }

    private ListNode getNewNode(int data) {
        return new ListNode(data);
    }

    public void insertNode(int data) {
        ListNode newNode = getNewNode(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }

    public void traverse() {
        for (ListNode ptr = this.head ; ptr != null ; ptr = ptr.next) {
            if (ptr.next == null) {
                System.out.print(ptr.data);
            } else {
                System.out.print(ptr.data + " => ");
            }
        }
    }

    public void insertNodeAtBeginning(int data) {
        ListNode newNode = getNewNode(data);
        if (this.head == null) {
            this.tail = newNode;
        } else {
            newNode.next = this.head;
        }

        this.head = newNode;
    }

    public void insertNodeAtEnd(int data) {
        ListNode newNode = getNewNode(data);
        if (this.tail == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }

    public ListNode sortList(ListNode head) {
        ListNode zeroHead = getNewNode(-1), oneHead = getNewNode(-1), twoHead = getNewNode(-1);
        ListNode zeroTail = zeroHead, oneTail = oneHead, twoTail = twoHead;

        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.data == 0) {
                zeroTail.next = ptr;
                zeroTail = ptr;
            } else if (ptr.data == 1) {
                oneTail.next = ptr;
                oneTail = ptr;
            } else {
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
        return null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1 ; i <= 10 ; i++) {
            linkedList.insertNode(i);
        }

        linkedList.insertNodeAtBeginning(0);
        linkedList.insertNodeAtEnd(11);

        linkedList.traverse();
    }
}
