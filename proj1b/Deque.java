public interface Deque<T> {
    /** Add the item before the first item.*/
    public void addFirst(T item);

    /** Add the item after the last item.*/
    public void addLast(T item);

    /** Check whether the array is empty.*/
    public boolean isEmpty();

    /** Get the size of items.*/
    public int size();

    /** Print the deque.*/
    public void printDeque();

    /** Remove the first item.*/
    public T removeFirst();

    /** Remove the last item.*/
    public T removeLast();

    /** Get the item of a specific index.*/
    public T get(int index);
}
