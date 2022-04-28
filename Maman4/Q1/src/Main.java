import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Random rand = new Random();
    public static void main(String[] args) {

        MySet<Integer> set1 = createRandomList();
        MySet<Integer> set2 = createRandomList();
        MySet<Integer> set3 = createRandomList();

        System.out.println("set1 " + set1);
        System.out.println("set2 " + set2);
        System.out.println("set3 " + set3);

        set1.union(set2);//union set2 into set1
        System.out.println("union " + set1);
        set1.intersect(set3); //intersect set3 into set1
        System.out.println("intersect " + set1);

        System.out.println("-------------SUBSET TIME---------------");
        Scanner in = new Scanner(System.in);
        MySet<Integer> set4 = new MySet<>();
        System.out.println("Enter first number:-");
        set4.insert(in.nextInt());
        System.out.println("Enter second number:-");
        set4.insert(in.nextInt());
        System.out.println("isSubset " + set4.isSubset(set2));
        System.out.println("-------------END SUBSET TIME---------------");

        System.out.println("-------------IS MEMBER TIME---------------");
        System.out.println("Enter a number:-");
        int num = in.nextInt();
        System.out.println(set1.isMember(num));
        set2.insert(num);
        System.out.println("set2 + insert " + set2);
        set3.delete(num);
        System.out.println("set3 + delete " + set3);
        System.out.println("-------------END IS MEMBER TIME---------------");
        System.out.println("-------------MIN TIME---------------");
        System.out.println("Min int " +MySetosh.<Integer>getMin(set2));
        System.out.println("-------------END TIME---------------");
        System.out.println("-------------MIN PERSON TIME---------------");
        MySet<Person> people = new MySet<>();
        people.insert(new Person(1, "lapid", "yair", LocalDate.of(2014, 9, 11)));
        people.insert(new Person(2, "donald", "trump",  LocalDate.of(1951, 3, 11)));
        people.insert(new Person(3, "malka", "zion",  LocalDate.of(1967, 3, 11)));
        people.insert(new Person(-4, "levi", "rami",  LocalDate.of(1985, 4, 22)));
        people.insert(new Person(5, "sharp", "derek",  LocalDate.of(1970, 1, 14)));
        System.out.println("Min person " +MySetosh.<Person>getMin(people));
        System.out.println("-------------END MIN PERSON TIME---------------");
    }

    private static MySet<Integer> createRandomList(){
        MySet<Integer> set = new MySet<>();
        for (int i = 0; i < 10; i++) {
            set.insert(rand.nextInt(0,100));//between 0 (inclusive) and n (exclusive).
        }
        return  set;
    }
}
