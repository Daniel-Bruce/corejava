package Multithreading;

public class SynchronizationDemo {
    //we used a synchronized method, however, it has its own challenges so we can use other custom lock methods
    private static int counter = 0;
    private static synchronized void increment(){
        counter++;
    }

    public static void main(String[] args) {
        Thread one = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread two = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter value:" + counter);
    }
}
