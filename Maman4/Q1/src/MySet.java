import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MySet<T extends Set<T>> implements Comparable<MySet<T>>{


    private  List<T> _set;

    public MySet() {
        _set = new ArrayList<>();
    }

    public MySet(List<T> set) {
        super();
        if (_set != null) {
            _set.addAll(set);
        }

    }

    public List<T> getSet() {
        return _set;
    }

    public void setSet(List<T> set) {
        _set = set;
    }

    @Override
    public String toString() {
        return super.toString()
                + "MySet{" +
                "_set=" + _set +
                '}';
    }

    @Override
    public int compareTo(MySet<T> other) {
        return  this.compareTo(other);
    }

    public boolean isMember(T item){
        return  _set.contains(item);
    }

    public  void insert(T item){
        if(!isMember(item))
            _set.add(item);
    }

    public void delete(T item){
        _set.remove(item);
    }
}
