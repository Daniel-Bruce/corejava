package Multithreading;

public class App {
    private int count = 0;
    public synchronized void increment(){
        count++;
    }
    public void doWork() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
            System.out.println("count1:"+count);

        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
            System.out.println("count2:"+count);

        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total count is:"+count);
    }

    public static void main(String[] args) {
    App app = new App();
    app.doWork();

    }
    }
