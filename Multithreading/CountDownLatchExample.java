package Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        // Create CountDownLatches for each phase with a count of 3 (3 threads)
        CountDownLatch latch1 = new CountDownLatch(3);
        CountDownLatch latch2 = new CountDownLatch(3);
        CountDownLatch latch3 = new CountDownLatch(3);

        // Create and start three threads
        Thread worker1 = new Thread(new LatchTask(latch1, latch2, latch3), "Worker 1");
        Thread worker2 = new Thread(new LatchTask(latch1, latch2, latch3), "Worker 2");
        Thread worker3 = new Thread(new LatchTask(latch1, latch2, latch3), "Worker 3");
        Thread worker4 = new Thread(new LatchTask(latch1, latch2, latch3), "Worker 4");

        worker1.start();
        worker2.start();
        worker3.start();
    }
}

class LatchTask implements Runnable {
    private final CountDownLatch latch1;
    private final CountDownLatch latch2;
    private final CountDownLatch latch3;

    public LatchTask(CountDownLatch latch1, CountDownLatch latch2, CountDownLatch latch3) {
        this.latch1 = latch1;
        this.latch2 = latch2;
        this.latch3 = latch3;
    }

    @Override
    public void run() {
        try {
            // Phase 1
            System.out.println(Thread.currentThread().getName() + " is working on phase 1");
            Thread.sleep(1000); // Simulating work
            System.out.println(Thread.currentThread().getName() + " finished phase 1");
            latch1.countDown(); // Decrement latch1 count
            latch1.await(); // Wait for other threads to finish phase 1

            // Phase 2
            System.out.println(Thread.currentThread().getName() + " is working on phase 2");
            Thread.sleep(1000); // Simulating work
            System.out.println(Thread.currentThread().getName() + " finished phase 2");
            latch2.countDown(); // Decrement latch2 count
            latch2.await(); // Wait for other threads to finish phase 2

            // Phase 3
            System.out.println(Thread.currentThread().getName() + " is working on phase 3");
            Thread.sleep(1000); // Simulating work
            System.out.println(Thread.currentThread().getName() + " finished phase 3");
            latch3.countDown(); // Decrement latch3 count
            latch3.await(); // Wait for other threads to finish phase 3

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
