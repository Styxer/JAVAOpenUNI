import java.util.Collections;

public class MySetosh<T> {

    public static<T extends Comparable<T>> T getMin(MySet<T> set){

      return Collections.min(set.getSet());
    }
}
