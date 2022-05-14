import java.util.Collections;

public class MySetosh<T> {

    //The method returns the minimum member in the group. The content of the group was not destroyed
    public static<T extends Comparable<T>> T getMin(MySet<T> set){

      return Collections.min(set.getSet());
    }
}
