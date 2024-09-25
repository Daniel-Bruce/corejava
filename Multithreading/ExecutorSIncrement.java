package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorSIncrement {
   private static final AtomicInteger count = new AtomicInteger(0);
   public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    int numberofTasks = 6;
    for (int i = 0; i < numberofTasks; i++) {
        executor.submit(()->{
            for (int j = 0; j < 1000; j++) {
                count.incrementAndGet();
            }
        });
    }
    executor.shutdown();
    while (!executor.isTerminated()) {
    }
    System.out.println("Final count: " + count.get());
   }
}
