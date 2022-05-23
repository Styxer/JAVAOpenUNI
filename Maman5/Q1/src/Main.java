import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int LOWER_BOUND = 0, UPPER_BOUND = 100;


    public static void main(String[] args) {

//        Random random = new Random();
//        ArrayList<Integer> arr = new ArrayList<>();
//        Scanner sc= new Scanner(System.in);
//
//        System.out.printf("insert the amount of numbers in the array");
//
//
//
//        System.out.printf("insert the amount of thread in the array");
//        int threadSize = sc.nextInt();
//        int sum = 0;
//        ArrayList<SumThread> threads = new ArrayList<>();
//        for (int i = 0; i < threadSize; i++) {
//            threads.add(new SumThread(arr, sum));
//            //threads.get()
//        }
//
//
//        int arrayAmount = sc.nextInt();
//        for (int i = 0; i < arrayAmount; i++) {
//            arr.add(random.nextInt(LOWER_BOUND,UPPER_BOUND +1));
//
//        }
//
//        int sumCheck = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            sumCheck += arr.get(i);
//        }
////        System.out.printf("arr sum is " + sumCheck);
//        Base b2 = new Base(4,7);
//        Base b1 = new Base(10);
//
//
//        System.out.println("sum1 = " + b1.sum());
//        System.out.println("dif1 = " + b1.getDif());
//        System.out.println("sum2 = " + b2.sum());
//        System.out.println("dif2 = " + b2.getDif());

        Base bs = new Base(10,20);
        Derived dr = new Derived(1,2,3);





    }
}