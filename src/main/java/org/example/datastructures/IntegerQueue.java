package org.example.datastructures;

public class IntegerQueue {
    private int[] queue;
    private int front, rear;

    public IntegerQueue(int size) {
        this.queue = new int[size];
        this.front = this.rear = -1;
    }

    public void insert(int data) {
        if (this.front == -1) {
            this.front = this.rear = 0;
        }

        if (this.front >= this.queue.length) {
            System.out.println("Queue overflow");
            System.exit(1);
        }

        this.queue[this.front++] = data;
    }

    public int delete() {
        if (this.rear == -1) {
            System.out.println("Queue underflow");
            System.exit(1);
        }

        if (this.rear >= this.front) {
            System.out.println("Queue underflow");
            System.exit(1);
        }

        int data = this.queue[this.rear];
        this.queue[this.rear++] = -1;
        return data;
    }

    public boolean isEmpty() {
        return this.rear == -1 || this.front < this.queue.length;
    }

    public static void main(String[] args) {
        IntegerQueue queue = new IntegerQueue(5);
        for (int i = 1 ; i <= 5 ; i++) {
            queue.insert(i);
        }

        System.out.println("Queue empty status: " + queue.isEmpty());
        while (!queue.isEmpty())
        {
            System.out.println(queue.delete());
        }
    }
}
