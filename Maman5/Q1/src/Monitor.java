import Model.ThreadSafeArrayList;

public class Monitor {
    private int num;
    private int count;
    private ThreadSafeArrayList<Integer> arrayList;

    public Monitor(int num, ThreadSafeArrayList<Integer> arrayList) {
        this.num = num;
        this.count = 0;
        this.arrayList = arrayList;
    }

    public ThreadSafeArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public synchronized void imDone(){
        count--;
        createAndRunThreads();
        notifyAll();
    }

    public synchronized void waitForThreads(){
        while (count > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    public synchronized void createAndRunThreads(){
        while (arrayList.size() > 1 && count < num){
            count++;
            (new SumThread(this)).start();
        }
    }
}
