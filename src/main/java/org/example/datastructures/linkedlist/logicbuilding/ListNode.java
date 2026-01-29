package org.example.datastructures.linkedlist.logicbuilding;

public class ListNode {
    public int data;
    public ListNode next;

    public ListNode() { data = 0; next = null; }

    public ListNode(int x) { data = x; next = null; }

    public ListNode(int x, ListNode next) { data = x; this.next = next; }
}
