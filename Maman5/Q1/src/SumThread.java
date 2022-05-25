import Model.ThreadSafeArrayList;

public class SumThread extends Thread{


    private ThreadSafeArrayList<Integer> arrayList;
    private Monitor monitor;

    public SumThread(Monitor monitor) {
        this.monitor = monitor;
        arrayList = monitor.getArrayList();
    }

    @Override
    public void run() {
        int firstNum = 0, secondNum = 0;

        try {
            firstNum = arrayList.remove(0);
        }catch (IndexOutOfBoundsException e){
            firstNum = 0;
        }
        if(firstNum != 0){
            try {
                secondNum = arrayList.remove(0);
            }catch (IndexOutOfBoundsException e){
                System.out.println(e.getStackTrace());
            }

            int sum = firstNum + secondNum;
            if(sum != 0){
                arrayList.add(sum);
            }
        }
        monitor.imDone();
    }
}
