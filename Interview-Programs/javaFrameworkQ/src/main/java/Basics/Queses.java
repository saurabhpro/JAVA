package Basics;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Queses {

    public static void main(String[] args) {
        //Using default constructor - uses natural ordering of numbers //Smaller numbers have higher priority
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        //Adding an element into priority queue - offer method
        priorityQueue.offer(24);
        priorityQueue.offer(15);
        priorityQueue.offer(9);
        priorityQueue.offer(45);

        System.out.println(priorityQueue);//[9, 24, 15, 45]
        //Peek method examples
        //peek method get the element with highest priority.
        System.out.println(priorityQueue.peek());//9
        //peek method does not change the queue
        System.out.println(priorityQueue);//[9, 24, 15, 45]
        //poll method gets the element with highest priority.
        System.out.println(priorityQueue.poll());//9
        //peek method removes the highest priority element from the queue.
        System.out.println(priorityQueue);//[24, 15, 45]
    }


    //A linear collection that supports element insertion and removal at both ends
    interface Deque<E> extends Queue<E> {
        void addFirst(E e);

        void addLast(E e);

        boolean offerFirst(E e);

        boolean offerLast(E e);

        E removeFirst();

        E removeLast();

        E pollFirst();

        E pollLast();

        E getFirst();

        E getLast();

        E peekFirst();

        E peekLast();

        boolean removeFirstOccurrence(Object o);

        boolean removeLastOccurrence(Object o);
    }

    //A Queue that additionally supports operations that wait for
    //the queue to become non-empty when retrieving an
    //element, and wait for space to become available in the queue when //storing an element.
    interface BlockingQueue<E> extends Queue<E> {
        //Same as in Queue Interface
        //Inserts the specified element into queue IMMEDIATELY //Throws exception in case of failure
        boolean add(E e);

        //Same as in Queue Interface
        //Inserts the specified element into queue IMMEDIATELY //Returns false in case of failure
        boolean offer(E e); //Same as in Queue Interface

        //Inserts the specified element into this queue, waiting //if necessary for space to become available.
        void put(E e) throws InterruptedException;

        //waiting up to the specified wait time
        boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException;

        //waits until element becomes available
        E take() throws InterruptedException;

        //waits for specified time and returns null if time expires
        E poll(long timeout, TimeUnit unit) throws InterruptedException;

        int remainingCapacity();

        boolean remove(Object o);

        boolean contains(Object o);

        int drainTo(Collection<? super E> c);

        int drainTo(Collection<? super E> c, int maxElements);
    }
}
