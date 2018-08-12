package Q14_04_Circular_Array;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Implement a class Circular Array that supports Array like data structure and which can be efficiently rotated.
 * The class should be generic and should support foreach loop on it
 */
public class CircularArrayWithIterator<T> implements Iterable<T> {
    /**
     * we can create a head variable which should point to start of circular array, and hence
     * Rather then shifting the whole array on rotate(intI) we just increment the head by intI
     */
    private T[] items;
    private int head = 0;

    CircularArrayWithIterator(int size) {
        //we cannot create T[size] array of generics, we can either case like below or use List<T>
        items = (T[]) new Object[size];
    }

    public T getItem(int i) {
        if (i < 0 || i >= items.length)
            throw new ArrayIndexOutOfBoundsException();

        return items[updateHead(i)];
    }

    public void setItem(int pos, T item) {
        this.items[updateHead(pos)] = item;
    }

    protected void rotate(int shiftRightByPosition) {
        head = updateHead(shiftRightByPosition);
    }

    private int updateHead(int shiftRightByPosition) {

        //operator % gives -ve value if (-ve % val) is done, ex: -8 % 3 = -2,
        // but instead we would want 6 as -ve for us means direction
        // for that we add the items.length (8) to the -ve value and then mod it
        if (shiftRightByPosition < 0) {
            shiftRightByPosition += items.length;   //-2 + 8 = 6
        }

        return (head + shiftRightByPosition) % items.length;    //(0 + 6) % 8 = 6 (/which is right)
    }

    @Override
    public Iterator<T> iterator() {
        //trying out something new
        Objects.requireNonNull(this);

        return new CircularArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        throw new UnsupportedOperationException("forEach");
    }


    //if the Type parameter is same as of the enclosing class,
    // compiler warns that the Type might be hiding the super one, hence TI and not T
    private class CircularArrayIterator implements Iterator<T> {
        //current is the offset from the rotated head not from the actual start of array
        private int current = -1;

        CircularArrayIterator() {
        }

        //the first iteration of foreach will call the hasNext() and then next()
        @Override
        public boolean hasNext() {
            return current < items.length - 1;
        }

        @Override
        public T next() {
            current++;
            return items[updateHead(current)];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            throw new UnsupportedOperationException("forEachRemaining");
        }
    }
}
