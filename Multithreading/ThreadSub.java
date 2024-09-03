package Multithreading;

public class ThreadSub extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 4; i++) {
            System.out.println("Thread-name:"+Thread.currentThread().getName()+"Thread-value:"+i);
        }

    }

    public static void main(String[] args) {
        ThreadSub threadSub = new ThreadSub();
        threadSub.start();
    }
}
