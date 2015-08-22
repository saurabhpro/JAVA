/**
 * Created by Saurabh on 8/26/2015.
 */

//package javaDS.list;

class Node {
    private int info;
    protected Node next;

    Node() {
        info = 0;
        next = null;
    }

    Node(int a, Node b) {
        info = a;
        next = b;
    }

    public int getData() {
        return info;
    }
}

public class LinkedListJava {
    Node head;
    Node tail;

    LinkedListJava() {
        head = tail = null;
    }

    boolean isEmpty() {
        if (head == null) return true;
        else return false;
    }

    void insertAtBeg(int num) {
        Node temp = new Node(num, null);

        if (head == null)
            head = temp;
        else {
            temp.next = head;
            head = temp;
        }

    }

    void insertAtEnd(int num) {
        Node temp = new Node(num, null);
        Node p = head;

        if (head == null)
            head = temp;

        while (p.next != null) {
            p = p.next;
        }
        p.next = temp;
    }


    void display() {
        Node p = head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        LinkedListJava list = new LinkedListJava();
        list.insertAtBeg(8);
        list.insertAtBeg(7);
        list.insertAtBeg(9);
        list.insertAtBeg(2);
        list.insertAtEnd(-77);

        list.display();
    }
}

