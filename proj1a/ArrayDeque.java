public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Constructor of the ArrayDeque.*/
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Add the item before the first item.*/
    public void addFirst(T item) {
        while (isFull()) {
            upsize();
        }
        items[nextFirst] = item;
        size += 1;
        minusOne(nextFirst);
    }

    /** Add the item after the last item.*/
    public void addLast(T item) {
        items[nextLast] = item;
        size += 1;
        plusOne(nextLast);   //The changes of items' length will effect nextLast.
        while (isFull()) {
            upsize();
        }
    }

    /** Use reminder to locate the nextFirst and nextLast.*/
    private int plusOne(int index) {
        return (index + 1) % items.length; //remainder
    }

    /** Use reminder to locate the nextFirst and nextLast.*/
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /** Check whether the array is full.*/
    private boolean isFull() {
        return size == items.length;
    }

    /** Resize the array's length.*/
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, plusOne(nextFirst), a, 0, size);
        items = a;
        nextFirst = minusOne(0);
        nextLast = size;
    }

    /** Cut the array,making it shorter.*/
    private void downsize() {
        resize(items.length / 2);
    }

    /** When the array is full,resizing it longer.*/
    private void upsize() {
        resize(items.length * 2);
    }

    /** Check whether the array is empty.*/
    public boolean isEmpty() {
        return size == 0;
    }

    /** Get the size of items.*/
    public int size() {
        return size;
    }

    /** Print the deque.*/
    public void printDeque() {
        for (int i = plusOne(nextFirst); i < nextFirst + size; i++) {
            System.out.println(get(i));
        }
    }

    /** Remove the first item.*/
    public T removeFirst() {
        while (items.length >= 16 && (size / items.length) < 0.25) {
            downsize();
        }
        T x = get(plusOne(nextFirst));
        items[plusOne(nextFirst)] = null;
        size -= 1;
        return x;
    }

    /** Remove the last item.*/
    public T removeLast() {
        while (items.length >= 16 && (size / items.length) < 0.25) {
            downsize();
        }
        T x = get(minusOne(nextLast));
        items[minusOne(nextLast)] = null;
        size -= 1;
        return x;
    }

    /** Get the item of a specific index.*/
    public T get(int index) {
        return items[index];
    }

    /** Deep copy.*/
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.size()];
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size;
        System.arraycopy(other, plusOne(nextFirst), items, 0, size);
    }
}