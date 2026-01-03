package org.example.datastructures;

public class SinglyLinkedListStack {
    private ListNode top;

    public SinglyLinkedListStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public ListNode getNewNode(int data) {
        try {
            return new ListNode(data);
        } catch (Exception exception) {
            throw new StackOverflowError("Stack overflow: " + exception.getMessage());
        }
    }

    public void push(int data) {
        ListNode newNode = getNewNode(data);
        newNode.next = this.top;
        this.top = newNode;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(1);
        }

        int data = this.top.data;
        ListNode currentTop = this.top;
        this.top = currentTop.next;
        currentTop = null;

        return data;
    }

    public static void main(String[] args) {
        SinglyLinkedListStack linkedList = new SinglyLinkedListStack();
        for (int i = 1 ; i <= 5 ; i++) {
            linkedList.push(i);
        }

        while(!linkedList.isEmpty()) {
            System.out.println(linkedList.pop());
        }
    }
}
