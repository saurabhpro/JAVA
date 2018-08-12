package Ch03_Stacks_and_Queues.Introduction;

import java.util.EmptyStackException;

class MyStack<T> {
    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.getData();
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class StackNode<T> {
        private final T data;
        private StackNode<T> next;

        StackNode(T data) {
            this.data = data;
        }

        T getData() {
            return data;
        }
    }
}
