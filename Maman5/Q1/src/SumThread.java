import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SumThread implements Runnable{


    private int firstIndex, secondIndex;
    private ArrayList<Integer> arr;
    private int ans = 0;
    private Lock lock;

    public SumThread(ArrayList<Integer> arr, int ans) {
     //   this.firstIndex = firstIndex;
      //  this.secondIndex = secondIndex;
        this.arr = arr;
        this.ans = ans;
        lock = new ReentrantLock();
    }

    @Override
    public void run() {
        lock.lock();
        try {
            ans += arr.get(firstIndex) + arr.get(secondIndex);
        }finally {
            lock.unlock();
        }

    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }

    public int getAns() {
        return ans;
    }
}
