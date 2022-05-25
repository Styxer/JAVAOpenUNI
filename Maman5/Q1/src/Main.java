import Model.ThreadSafeArrayList;

import javax.swing.*;
import java.util.Random;

public class Main {

    static final int LOWER_BOUND = 0, UPPER_BOUND = 100;


    public static void main(String[] args) {
        Random random = new Random();
        int  threadsNum=0, arraySize=0;
        try {
            arraySize = Integer.parseInt(JOptionPane.showInputDialog("Enter number of variables"));
            threadsNum = Integer.parseInt(JOptionPane.showInputDialog("Enter number of Threads"));
        }catch (NumberFormatException e){
            System.out.println("ERROR: input can be numbers only");
            System.exit(1);
        }
        if (threadsNum <= 0 || arraySize <= 0 ){
            System.out.println("ERROR: thread number and array size must be positive");
            System.exit(1);
        }

        ThreadSafeArrayList<Integer> arrayList  = new ThreadSafeArrayList<>(arraySize);
        int testSum = 0;
        for (int i = 0; i < arraySize; i++) {
            int num = random.nextInt(0, 101);
            arrayList.add(num);
            testSum += num;
        }

        Monitor monitor  = new Monitor(threadsNum,arrayList);
        monitor.createAndRunThreads();
        monitor.waitForThreads();

        System.out.println("Sum from test is " + testSum);
        System.out.println("Sum from threads is " + arrayList.get(0));





    }
}