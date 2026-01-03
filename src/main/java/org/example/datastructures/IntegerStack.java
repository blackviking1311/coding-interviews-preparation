package org.example.datastructures;

public class IntegerStack {
    private final int[] stack;
    private int top;

    public IntegerStack(int size) {
        this.stack = new int[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public int peek(int index) {
        if (this.top == -1) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }

        return this.stack[this.top];
    }

    public void push(int data) {
        if (this.top >= this.stack.length)
        {
            System.err.println("Stack overflow");
            System.exit(1);
        }

        this.top++;
        this.stack[this.top] = data;
    }

    public int pop() {
        if (this.top == -1) {
            System.err.println("Stack underflow");
            System.exit(1);
        }

        return this.stack[this.top--];
    }

    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack(5);
        for (int i = 0 ; i < 5 ; i++) {
            stack.push(i + 1);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " : ");
        }
    }
}
