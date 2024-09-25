package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceIncrementExample {
    // Use AtomicInteger to ensure thread-safe increments
    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        // Create a FixedThreadPool with 6 threads
        ExecutorService executor = Executors.newFixedThreadPool(6);

        // Number of tasks (each task will increment the count 1000 times)
        int numberOfTasks = 60;

        // Submit 60 tasks to the executor, each task increments the count 1000 times
        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(() -> {
                // Each task increments the count 1000 times
                for (int j = 0; j < 1000; j++) {
                    count.incrementAndGet(); // Thread-safe increment
                }
            });
        }

        // Shutdown the executor and wait for all tasks to complete
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all tasks to complete
        }

        // Print the final count value
        System.out.println("Final Count Value: " + count.get());
    }
}
