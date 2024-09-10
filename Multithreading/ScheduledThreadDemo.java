package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new ProbTask(), 1000 , 2000, TimeUnit.MILLISECONDS);

        try {
            if(!service.awaitTermination(5000, TimeUnit.MILLISECONDS)){
                service.shutdown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ProbTask implements Runnable{

    @Override
    public void run() {
        System.out.println("probing end point for updates....");
    }
}
