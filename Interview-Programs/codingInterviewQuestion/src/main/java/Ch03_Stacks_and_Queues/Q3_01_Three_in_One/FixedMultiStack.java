package Ch03_Stacks_and_Queues.Q3_01_Three_in_One;

import CtCILibrary.AssortedMethods;

import java.util.EmptyStackException;
import java.util.stream.IntStream;

class FixedMultiStack {
    private final int numberOfStacks = 3;
    private final int stackCapacity;
    private final int[] values;
    private final int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    /* Push value onto stack. */
    public void push(int stackNum, int value) throws FullStackException {
        /* Check that we have space for the next element */
        if (isFull(stackNum)) {
            throw new FullStackException();
        }

        /* Increment stack pointer and then update top value. */
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /* Pop item from top stack. */
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; // Get top
        values[topIndex] = 0; // Clear
        sizes[stackNum]--; // Shrink
        return value;
    }

    /* Return top element. */
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    /* Return if stack is empty. */
    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    /* Return if stack is full. */
    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    /* Returns index of the top of the stack. */
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public int[] getValues() {
        return values;
    }

    private int[] getStackValues(int stackNum) {
        return IntStream.range(0, sizes[stackNum]).map(i -> values[stackNum * stackCapacity + i]).toArray();
    }

    public String stackToString(int stackNum) {
        int[] items = getStackValues(stackNum);
        return stackNum + ": " + AssortedMethods.arrayToString(items);
    }
}
