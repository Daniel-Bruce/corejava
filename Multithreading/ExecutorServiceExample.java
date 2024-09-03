package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class ExecutorServiceExample {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {// creates a single-threaded executor where tasks are executed
            for (int i = 0; i < 5; i++) {
                service.execute(new Work(i));
            }
        }
    }
}

class Work implements Runnable{
  private final  int taskid;

    Work(int taskid) {
        this.taskid = taskid;
    }

    @Override
    public void run(){

            System.out.println("Current task: "+taskid + " executed by thread:"+Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

