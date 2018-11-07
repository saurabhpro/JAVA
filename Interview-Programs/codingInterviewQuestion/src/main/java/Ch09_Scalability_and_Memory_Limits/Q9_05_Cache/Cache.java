package Ch09_Scalability_and_Memory_Limits.Q9_05_Cache;

import java.util.HashMap;

class Cache {
    private static final int MAX_SIZE = 10;
    private final HashMap<String, Node> map;
    private Node head;
    private Node tail;
    private int size = 0;

    public Cache() {
        map = new HashMap<>();
    }

    private void moveToFront(Node node) {
        if (node == head) {
            return;
        }
        removeFromLinkedList(node);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        size++;

        if (tail == null) {
            tail = node;
        }
    }

    public void moveToFront(String query) {
        Node node = map.get(query);
        moveToFront(node);
    }

    private void removeFromLinkedList(Node node) {
        if (node == null) {
            return;
        }

        if (node.next != null || node.prev != null) {
            size--;
        }

        Node prev = node.prev;
        if (prev != null) {
            prev.next = node.next;
        }

        Node next = node.next;
        if (next != null) {
            next.prev = prev;
        }

        if (node == head) {
            head = next;
        }

        if (node == tail) {
            tail = prev;
        }

        node.next = null;
        node.prev = null;
    }

    public String[] getResults(String query) {
        if (map.containsKey(query)) {
            Node node = map.get(query);
            moveToFront(node);
            return node.results;
        }
        return null;
    }

    public void insertResults(String query, String[] results) {
        if (map.containsKey(query)) {
            Node node = map.get(query);
            node.results = results;
            moveToFront(node);
            return;
        }

        Node node = new Node(query, results);
        moveToFront(node);
        map.put(query, node);

        if (size > MAX_SIZE) {
            map.remove(tail.query);
            removeFromLinkedList(tail);
        }
    }
}