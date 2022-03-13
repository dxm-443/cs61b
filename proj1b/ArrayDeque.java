public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int length;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        length = items.length;
    }

    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /** help method
     * get nextFirst and nextLast
     * Use reminder to locate the nextFirst and nextLast
     */

    /** helper method
     * resize the length of array
     */

    private int addOne(int index){
        return (index + 1) % length;
    }

    private int minusOne(int index) {
        return (length + index - 1) % length;
    }

    private void upsize(){
        int newLength = length * 2;
        T[] tmp = (T[]) new Object[newLength];
        System.arraycopy(items, addOne(nextFirst), tmp, 0, size);
        items = tmp;
        length = items.length;
        nextFirst = minusOne(0);
        nextLast = addOne(size - 1);
    }

    private void downsize(){
        int newLength = length / 2;
        T[] tmp = (T[]) new Object[newLength];
        System.arraycopy(items, addOne(nextFirst), tmp, 0, size);
        items = tmp;
        length = items.length;
        nextFirst = minusOne(0);
        nextLast = addOne(size - 1);
    }

    @Override
    public void addFirst(T i){
        if ((float)size / length >= 0.5){
            upsize();
        }
        items[nextFirst] = i;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    @Override
    public void addLast(T i){
        if ((float)size / length >= 0.5){
            upsize();
        }
        items[nextLast] = i;
        nextLast = addOne(nextLast);
        size += 1;
    }

    @Override
    public T removeFirst(){
        if ((float)size / length < 0.5){
            downsize();
        }
        if (size == 0){
            return null;
        }
        nextFirst = addOne(nextFirst);
        T ret = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return ret;
    }

    @Override
    public T removeLast(){
        if ((float)size / length < 0.5){
            downsize();
        }
        if (size == 0){
            return null;
        }
        nextLast = minusOne(nextLast);
        T ret = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return ret;
    }

    @Override
    public T get(int index){
        if (index > length - 1 | index < 0){
            return null;
        }
        return items[index];
    }

    @Override
    public void printDeque(){
        for (int i = nextFirst; i < nextFirst + size; i++ ){
            System.out.print(get(addOne(i)) + " ");
        }
    }

    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[8];
        size = other.size;
        nextFirst = other.nextFirst;

        for (int i = nextFirst; i < nextFirst + size; i++ ){
            addLast(get(addOne(i)));
        }
    }
}
