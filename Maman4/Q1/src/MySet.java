import java.util.*;


//Represents a  generic class used to define sets of members of some type without duplicates
public class MySet<T extends Comparable<T>> implements  Iterator<T> {

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

    //An action that receives a group and checks if it represents a subgroup of the group.
    public boolean isSubset(MySet<T> otherSet) {
        return otherSet.getSet().containsAll(_set);
    }



    //An action that receives an organ and checks if it belongs to a group.
    public boolean isMember(T item) {
        return _set.contains(item);
    }

    //- A unifying action that receives a group and unites it with some other group.
    public void union(MySet<T> otherSet) {
        for (int i = 0; i < otherSet.size(); i++) {
            insert(otherSet.getSet().get(i));
        }
    }

    //A cutting operation that receives a group and performs group cutting.
    public void intersect(MySet<T> otherSet) {
        Set<T> s1 = new HashSet<T>(otherSet.getSet());
        Set<T> s2 = new HashSet<T>(_set);

        s1.retainAll(s2);
        _set = new ArrayList<>(s1);
    }

    //An action that receives an item and adds it to a group.
    // In case an equal item already exists in the group the action will do nothing.
    public void insert(T item) {
        if (!isMember(item))
            _set.add(item);
    }

    //An action that receives an item and removes it from the group.
    // If the item does not exist the operation will do nothing.
    public void delete(T item) {
        _set.remove(item);
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





