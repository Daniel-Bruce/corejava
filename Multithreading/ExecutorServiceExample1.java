package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//A FixedThreadPool is an ExecutorService that uses a fixed number of threads.
//If all threads are busy, the tasks are placed in a queue until a thread becomes available.

public class ExecutorServiceExample1 {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            for (int i = 0; i < 10; i++) {
                service.execute(new TASK(i));

            }
        }

        try (ExecutorService service2 = Executors.newFixedThreadPool(2)) {
            for (int i = 0; i < 10; i++) {
                service2.execute(new TASK(i));
            }
        }
    }
}

class TASK implements Runnable{
   private final int taskid;

    TASK(int taskid) {
        this.taskid = taskid;
    }

    @Override
    public void run(){
        System.out.println("Task:"+taskid + " executed by thread:"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
