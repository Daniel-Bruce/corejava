package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cpuintensivetask {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        try (ExecutorService service = Executors.newFixedThreadPool(cores)) {
            System.out.println("Created thread pool with: " + cores + "cores");

            for (int i = 0; i < 20; i++) {
                service.execute(new CPutask());
            }
        }
    }
}

class CPutask implements Runnable{

    @Override
    public void run() {
        System.out.println("Some CPU intensive tasks being done by: "+Thread.currentThread().getName());
    }
}
