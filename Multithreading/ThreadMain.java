package Multithreading;

public class ThreadMain extends Thread{
   private  String threadName;
   private int sum = 0;

    public ThreadMain(String threadName){
        this.threadName=threadName;
    }
    @Override
    public synchronized void run() {
        int localsum = 0;
        for (int i = 0; i < 10; i++) {
            synchronized (ThreadMain.class) {
                sum += i;
                localsum +=i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
            System.out.println("ThreadNAme:"+threadName+ " ThreadValue:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Thread:" + threadName + " - Sum : " + sum);

    }}

class Mainp{
    public static void main(String[] args) {
        ThreadMain threadMain = new ThreadMain("A");
        ThreadMain threadMain2 = new ThreadMain("B");
        ThreadMain threadMain3 = new ThreadMain("C");

        threadMain2.start();
        threadMain3.start();
        threadMain.start();

        try {
            threadMain.join();
            threadMain2.join();
            threadMain3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}