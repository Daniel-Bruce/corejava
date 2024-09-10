package Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

// Main class
public class SharedCounterExample {
    // Shared counter variable with thread-safe access
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        // Number of threads to create
        int numberOfThreads = 10;

        // Create and start threads
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(new IncrementTask(), "Thread- "+i);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the final counter value
        System.out.println("Final Counter Value: " + counter.get());
    }

    // Runnable task that increments the counter
    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            // Each thread increments the counter 1000 times
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // Thread-safe increment
            }
            System.out.println(Thread.currentThread().getName() + " finished incrementing.");
        }
    }
}
