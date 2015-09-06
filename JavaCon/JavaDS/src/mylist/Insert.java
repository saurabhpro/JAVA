package mylist;

/**
 * Created by Saurabh on 9/5/2015.
 */
public class Insert {
    static boolean isEmpty(Node head) {
        return head == null;
    }

    public Node insertAtBeg(int num, Node head) {
        Node temp = new Node(num, null);

        if (isEmpty(head))
            head = temp;
        else {
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public Node insertAtEnd(int num, Node head) {
        Node temp = new Node(num);
        Node p = head;

        if (isEmpty(head))
            head = temp;

        while (p.next != null) {
            p = p.next;
        }
        p.next = temp;

        return head;
    }

    public Node insert(int num, Node head, int pos) {
        Node temp = new Node(num);

        if (isEmpty(head))
            head = temp;
        else if (pos == 0) {
            temp.next = head;
            head = temp;
        } else {
            int counter = 0;
            Node p = head;
            while (counter++ < pos - 1 && p != null)
                p = p.next;


            if (p != null) {
                temp.next = p.next;
                p.next = temp;
            }
        }
        return head;
    }
}
