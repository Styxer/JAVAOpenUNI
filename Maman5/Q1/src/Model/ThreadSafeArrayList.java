package Model;

import java.util.Iterator;

public class ThreadSafeArrayList<E> implements Container<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int elementCount = 0;
    private int arrayCapacity = 0;

    public ThreadSafeArrayList(int arrayCapacity) {
        array = new Object[arrayCapacity];
    }

    public ThreadSafeArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    private void increaseCapacity(){
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array,0, newArray, 0, array.length);
        array = newArray;

    }

    @Override
    public void add(E e) {
        synchronized (this){
            if(elementCount == array.length){
                increaseCapacity();
            }
            array[elementCount++] = e;
        }
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        synchronized (this){
            if
        }
    }

}
