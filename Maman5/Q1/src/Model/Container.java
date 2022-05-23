package Model;

public interface Container<E> extends Iterable<E> {
    void add(E e);
    E get(int index);
}
