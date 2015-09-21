import java.util.LinkedList;

/**
 * Created by Saurabh on 9/20/2015.
 */
public class LinkedListGetRemove {
    static LinkedList<String> linkedList;

    LinkedListGetRemove() {
        linkedList = new LinkedList<>();

        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");
        linkedList.add("Four");
        linkedList.add("Five");
        linkedList.add("Six");
        linkedList.add("Five");
        linkedList.add("One");
        linkedList.add("One");

    }

    static void removeList() {

        System.out.println("\\*Remove*/");

        System.out.println("1. remove() : " + linkedList.remove());
        System.out.println("2. remove(index) : " + linkedList.remove(2));
        System.out.println("3. remove(object) : " + linkedList.remove("One"));
        System.out.println("4. removeFirst() : " + linkedList.removeFirst());
        System.out.println("5. removeLast() : " + linkedList.removeLast());
        System.out.println("6. removeFirstOccurrence(object) : " + linkedList.removeFirstOccurrence("Five"));
        System.out.println("7. removeLastOccurrence(object) : " + linkedList.removeLastOccurrence("One"));

        /*
        Current List : [One, Two, Three, Four, Five, Six, Five, One, One]

        1. remove() : One
        2. remove(index) : Four
        3. remove(object) : true    !!!
        4. removeFirst() : Two
        5. removeLast() : One
        6. removeFirstOccurrence() : true       !!!
        7. removeLastOccurrence() : false       !!!
         */
    }

    static void pollList() {
        System.out.println("\\*Poll*/");
        System.out.println("poll - " + linkedList.poll());
        System.out.println("pollFirst - " + linkedList.pollFirst());
        System.out.println("pollLast - " + linkedList.pollLast());

        /*
        Current List : [Three, Six, Five]

        Poll
        Three
        Six
        Five
         */
    }

    static void peekList() {
        System.out.println("\\*Peek*/");
        System.out.println("peek - " + linkedList.peek());      //by default shows first element from the list
        System.out.println("peekFirst - " + linkedList.peekFirst());
        System.out.println("peekLast - " + linkedList.peekLast());

        /*
        Current List : [Three, Six, Five]

        Peek
        Three
        Three
        Five
         */
    }

    /**
     * for list with no elements poll... [which usually removes an element doesnt throw an exception - return null
     * similarly peek... which usually displays element from list doesnt throw exception            - return null
     * <p>
     * get... and remove... methods should not be used because they throw exception when empty list encountered!
     * Exception - java.util.NoSuchElementException
     */

    static void getList() {
        System.out.println("\\*get*/");
        System.out.println("get(index) - " + linkedList.get(2));
        System.out.println("getFirst - " + linkedList.getFirst());
        System.out.println("getLast - " + linkedList.getLast());

        /*
        Current List : [Three, Six, Five]

        GET
        Five
        Three
        Five
         */
    }

    public static void main(String[] args) {
        LinkedListGetRemove list = new LinkedListGetRemove();
        System.out.println("Current List : " + linkedList);
        removeList();
        System.out.println("\nCurrent List : " + linkedList);
        peekList();
        System.out.println("\nCurrent List : " + linkedList);
        getList();
        System.out.println("\nCurrent List : " + linkedList);
        pollList();

        System.out.println("\nCurrent List : " + linkedList);
        System.out.println("List with NO ELement");
        pollList();
        //   removeList();
        //   getList();
        peekList();


    }
}
