package org.example.datastructures;

public class DoublyLinkedList {
    private DoubleListNode head, tail;

    public DoublyLinkedList() {
        this.head = this.tail = null;
    }

    public DoubleListNode getNewDoublyNode(int data) {
        return new DoubleListNode(data);
    }

    public void insertNewNode(int data) {
        DoubleListNode newNode = getNewDoublyNode(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
    }

    public void insertNewNodeAtBeginning(int data) {
        DoubleListNode newNode = new DoubleListNode(data);
        if (this.head == null) {
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
        }
        this.head = newNode;
    }

    public void traverse() {
        for (DoubleListNode ptr = this.head ; ptr != null ; ptr = ptr.next) {
            if (ptr.next == null) {
                System.out.print(ptr.data);
            } else {
                System.out.print(ptr.data + " => ");
            }
        }
    }

    public DoubleListNode findMiddleElement() {
        DoubleListNode slow = this.head, fast = this.head;
        if (this.head == null) return null;
        if (this.head.next == null) return this.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        for (int i = 1 ; i <= 10 ; i++) {
            linkedList.insertNewNode(i);
        }
        linkedList.insertNewNodeAtBeginning(0);
        linkedList.traverse();

        DoubleListNode middleNode = linkedList.findMiddleElement();
        if (middleNode != null) {
            System.out.println("\nMiddle Element: " + middleNode.data);
        }
    }
}
