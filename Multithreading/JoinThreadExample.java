package Multithreading;

public class JoinThreadExample {
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1:"+i);
            }
        });

        Thread two = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2:"+i);
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
        System.out.println("Done executing the threads!");
    }
}
