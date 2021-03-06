/**
 * Deque (usually pronounced like “deck”) is an irregular acronym of
 * double-ended queue.
 */
public class LinkedListDeque<T> implements Deque<T>{

    private static class StuffNode {
        T item;
        StuffNode prev;
        StuffNode next;

        private StuffNode(T i, StuffNode s, StuffNode n) {
            item = i;
            prev = s;
            next = n;
        }
    }

    /** The items in a deque.*/
    private StuffNode sentinel;
    private int size;

    /** Create an empty list.*/
    public LinkedListDeque() {
        size = 0;
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /** Add item in the first of the list.*/
    @Override
    public void addFirst(T i) {
        size += 1;
        StuffNode first =  new StuffNode(i, sentinel, sentinel.next);
        sentinel.next.next.prev = first;
        sentinel.next = first;
    }

    /** Add item in the last of the list.*/
    @Override
    public void addLast(T i) {
        size += 1;
        StuffNode last = new StuffNode(i, sentinel.prev, sentinel);
        sentinel.prev.prev.next = last;
        sentinel.prev = last;
    }

    /** Check whether the list is empty.*/
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Get the size of the list.*/
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last,
     * separated by a space. Once all the items have been printed,
     * print out a new line.
     */
    @Override
    public void printDeque() {
        for (int j = 0; j < size; j++) {
            System.out.println(sentinel.next.item);
            sentinel = sentinel.next;
        }
    }

    /** Removes and returns the item at the front of the deque,
     * if no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        size -= 1;
        if (sentinel.next == sentinel) {
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return sentinel.next.item;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        size -= 1;
        if (sentinel.prev == sentinel) {
            return null;
        }
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return sentinel.prev.item;
    }

    /** Get the item in index i.*/
    @Override
    public T get(int index) {
        if (index > size && index < 0) {
            System.out.println("The index is beyond the size!");
        }
        for (int j = 0; j <= index; j++) {
            sentinel = sentinel.next;
        }
        return sentinel.item;
    }

    /** Deep copy.*/
    public LinkedListDeque(LinkedListDeque<T> other) {
        size = 0;

        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

        for (int i = 0; i < other.size; i++) {
            addLast(other.get(i));
        }
    }
}