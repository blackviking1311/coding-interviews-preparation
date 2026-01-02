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
