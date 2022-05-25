package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class ThreadSafeArrayList<E> implements Container<E> {

   // private static final int DEFAULT_CAPACITY = 10;
    private ArrayList<Object> array;
    //private int elementCount = 0;
   // private int arrayCapacity = 0;

    public ThreadSafeArrayList(int arrayCapacity) {
        array = new ArrayList<>(arrayCapacity);
    }

    public ThreadSafeArrayList() {
        array = new ArrayList<>();
    }

//    private void increaseCapacity(){
//        Object[] newArray = new Object[array.length * 2];
//        System.arraycopy(array,0, newArray, 0, array.length);
//        array = newArray;
//
//    }

    @Override
    public void add(E e) {
        synchronized (this){
            array.add(e);
        }
    }

    @Override
    public E get(int index) {
        synchronized (this){
            if((index < 0) || index > array.size()){
                System.out.println("wrong index");
            }
            return (E)array.get(index);
        }
    }

    @Override
    public E remove(int index) {
        synchronized (this) {
            if ((index < 0) || index > array.size()) {
                System.out.println("wrong index");
            }
            E item = get(index);
            array.remove(item);
            return item;
        }
    }

    public int size(){
        synchronized (this){
            return array.size();
        }
    }


    @Override
    public Iterator<E> iterator() {
        Iterator it = new Iterator() {

            private int index = 0;

            @Override
            public boolean hasNext() {
               return  ((array.size() > index) && (array.get(index) != null));
            }

            @Override
            public E next() {
                while (index < array.size()){
                    return (E)array.get(index++);
                }
                return  null;
            }
        };
        return it;
    }
}
