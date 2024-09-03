package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//A CachedThreadPool creates new threads as needed, but will reuse previously constructed threads when they are available.
//It is suitable for applications that launch many short-lived tasks.

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 1000; i++) {
                service.execute(new Task1(i));
            }
        }

    }}

class Task1 implements Runnable{
    private final int taskid;

    Task1(int taskid) {
        this.taskid = taskid;
    }

    @Override
    public void run(){
        System.out.println("Task:"+taskid+" being executed by:"+Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
