package org.example.datastructures;

public class DoubleListNode {
    int data;
    DoubleListNode next, prev;

    public DoubleListNode() {
        this.next = prev = null;
    }

    public DoubleListNode(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}
