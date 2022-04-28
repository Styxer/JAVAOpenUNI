import java.util.*;

public class MySet<T extends Comparable<T>> implements Comparable<MySet<T>>, Iterator<T> {

    private List<T> _set;
    private int _currentIndex = 0;


    public MySet() {
        _set = new ArrayList<>();
    }

    public MySet(List<T> set) {
        super();
        if (_set != null) {
            _set.addAll(set);
        }
    }

    public int size() {
        return _set.size();
    }

    public int getCurrentIndex() {
        return _currentIndex;
    }

    public List<T> getSet() {
        return _set;
    }

    public void setSet(List<T> set) {
        _set = set;
    }

    @Override
    public String toString() {
        return " MySet{" +
                "_set=" + _set +
                '}';
    }

    public boolean isSubset(MySet<T> otherSet) {
        return otherSet.getSet().containsAll(_set);
    }


    public boolean isMember(T item) {
        return _set.contains(item);
    }

    public void union(MySet<T> otherSet) {
        for (int i = 0; i < otherSet.size(); i++) {
            insert(otherSet.getSet().get(i));
        }
    }

    public void intersect(MySet<T> otherSet) {
        Set<T> s1 = new HashSet<T>(otherSet.getSet());
        Set<T> s2 = new HashSet<T>(_set);

        s1.retainAll(s2);
        _set = new ArrayList<>(s1);
    }

    public void insert(T item) {
        if (!isMember(item))
            _set.add(item);
    }

    public void delete(T item) {
        _set.remove(item);
    }



    @Override
    public int compareTo(MySet<T> other) {
        return 0; //TODO
    }



    @Override
    public boolean hasNext() {
        return _currentIndex < _set.size();
    }

    @Override
    public T next() {
        return _set.get(_currentIndex++);
    }


}





