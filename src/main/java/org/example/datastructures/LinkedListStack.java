package org.example.datastructures;

import java.util.Optional;

public class LinkedListStack {
    private DoubleListNode head, top;

    public LinkedListStack() {
        this.head = this.top = null;
    }

    public DoubleListNode getNewNode(int data) {
        return new DoubleListNode(data);
    }

    public void push(int data) {
        DoubleListNode newNode = getNewNode(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.top.next = newNode;
            newNode.prev = this.top;
        }
        this.top = newNode;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(1);
        }

        int data = this.top.data;
        DoubleListNode nodeToBeRemoved = this.top;
        if (nodeToBeRemoved.prev == null) {
            this.head = this.top = null;
        } else {
            this.top = nodeToBeRemoved.prev;
        }

        nodeToBeRemoved = null;
        return data;
    }

    public Optional<DoubleListNode> peek() {
        return Optional.ofNullable(this.top);
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
