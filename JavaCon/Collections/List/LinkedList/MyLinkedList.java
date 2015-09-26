import java.util.Scanner;

/**
 * Created by Saurabh on 9/21/2015.
 */
interface MyIterator {
    boolean hasNext();

    Object next();
}

class LinkList implements MyIterator {
    Node head;
    Node tail;

    LinkList() {
        head = tail = null;
    }

    void addAtBeg(int num) {
        Node temp = new Node(num);
        if (head == null)
            head = temp;
        else {
            temp.next = head;
            head = temp;
        }
    }

    void addAtEnd(int num) {
        Node temp = new Node(num);
        if (head == null)
            head = temp;
        else {
            Node current = head;

            while (current.next != null)
                current = current.next;


            current.next = temp;
        }
    }

    Node delAtBeg() {
        Node temp = head;
        if (head != null) {
            temp = head;
            head = head.next;
        }
        return temp;
    }

    Node delAtEnd() {
        Node current = head;
        Node previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        Node temp = current;

        // assert previous != null;
        if (previous != null) {
            previous.next = null;
        }

        return temp;
    }

    boolean find(int num) {
        Node current = head;
        while (current.getInfo() != num && current != null)
            current = current.next;

        return current!=null;
    }

    Node findAndDelete(int key) {
        Node current = head;
        Node previous = null;

        while (current.getInfo() != key) {
            if (current.next != null) {
                previous = current;
                current = current.next;
            }
        }

        if (current == head)
            head = head.next;
        else
            previous.next = current.next;

        return current;

    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getInfo() + " ");
            current = current.next;
        }
    }

    public MyIterator myIterator() {
        nxt = hasNxt = this.nxt;
        return this;
    }

    Node hasNxt, nxt;

    @Override
    public boolean hasNext() {
        boolean flag = false;
        if (this.hasNxt != null) {
            flag = true;
            this.hasNxt = this.hasNxt.next;
        }
        return flag;
    }

    @Override
    public Object next() {
        Object o = nxt.getInfo();
        nxt = nxt.next;

        return o;
    }

    public boolean isEmpty() {
        boolean flag = false;
        if (head == null) flag = true;
        return flag;
    }

    static class Node {

        protected Node next;
        private int info;

        Node(int info) {
            this.info = info;
            next = null;    //not necessary as next is instance variable
        }

        int getInfo() {
            return info;
        }
    }
}

public class MyLinkedList {

    static void fixedDriverFunction() {
        LinkList list = new LinkList();
        list.addAtBeg(5);
        list.addAtBeg(4);
        list.addAtEnd(7);
        list.addAtEnd(9);
        list.addAtBeg(2);
        list.addAtEnd(12);

        list.display();
        System.out.println("Deleted from beginning: " + list.delAtBeg().getInfo());
        list.display();
        System.out.println("Deleted from beginning: " + list.delAtBeg().getInfo());
        list.display();
        System.out.println("Deleted from end: " + list.delAtEnd().getInfo());
        list.display();
    }

    static void userDefinedDriverFunc() {
        LinkList list = new LinkList();
        byte choice = 0, choice1;
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            System.out.println("\nMenu For Dequeue\n1. Add\n2. Delete\n3. Display\n4. Exit ");
            System.out.println("Enter Your Choice");
            try {
                choice = sc.nextByte();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 1:
                    here:
                    for (; ; ) {
                        System.out.println("\nMenu\n1. Add-Beg\n2. Add-End\n3. Display\n4. BackToMainMenu");
                        System.out.println("Enter your choice: ");
                        choice1 = sc.nextByte();
                        switch (choice1) {
                            case 1:
                                int num = sc.nextInt();
                                list.addAtBeg(num);
                                break;
                            case 2:
                                num = sc.nextInt();
                                list.addAtEnd(num);
                                break;
                            case 3:
                                list.display();
                                break;
                            case 4:
                                break here;
                            default:
                                System.out.println("Wrong choice entered!!!");
                        }
                    }
                    break;

                case 2:
                    here:
                    for (; ; ) {
                        System.out.println("\nMenu\n1. Del-Beg\n2. Del-End\n3. Display\n4. BackToMainMenu");
                        System.out.println("Enter your choice: ");
                        choice1 = sc.nextByte();
                        switch (choice1) {
                            case 1:
                                LinkList.Node temp = list.delAtBeg();
                                //static inner class
                                if (temp != null)
                                    System.out.println(temp.getInfo());
                                else System.out.println("List has no elements to delete!!!");
                                break;
                            case 2:
                                temp = list.delAtBeg();
                                if (temp != null)
                                    System.out.println(temp.getInfo());
                                else System.out.println("List has no elements to delete!!!");

                                break;
                            case 3:
                                list.display();
                                break;
                            case 4:
                                break here;
                            default:
                                System.out.println("Wrong choice entered!!!");
                        }
                    }
                    break;

                case 3:
                    list.display();
                    break;
                case 4:
                    System.exit(47);
            }
        }
    }

    public static void main(String[] args) {
        //fixedDriverFunction();
        userDefinedDriverFunc();
    }
}