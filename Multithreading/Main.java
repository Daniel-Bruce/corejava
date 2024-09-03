package Multithreading;

public class Main implements Runnable {
    @Override
    public void run() {
     int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum+=i;
            System.out.println("ThreadName:"+Thread.currentThread().getName()+" ThreadValue :"+Thread.currentThread().threadId());
            System.out.println("Thread:"+Thread.currentThread().getName()+" - Sum : "+sum);}
    }
}

class MainThread extends Thread{
    public static void main(String[] args) {
        Main main = new Main();
       /* Thread thread = new Thread(main);
        thread.start();*/

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum+=i;
                    System.out.println("ThreadName:"+Thread.currentThread().getName()+" ThreadValue :"+Thread.currentThread().threadId());
                    System.out.println("Thread:"+Thread.currentThread().getName()+" - Sum : "+sum);}
            }

    });
        thread1.start();
}}
