package Multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("All chefs are ready. Let's proceed!"));
        Thread chef1 = new Thread(new Chif(cyclicBarrier), "Chef1");
        Thread chef2 = new Thread(new Chif(cyclicBarrier), "Chef2");
        Thread chef3 = new Thread(new Chif(cyclicBarrier), "Chef3");

        chef1.start();
        chef2.start();
        chef3.start();
        
}}

class Chif implements Runnable{
    private final CyclicBarrier cyclicBarrier;

    Chif(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing phase 1....");
        try {
         Thread.sleep(500);
     } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     System.out.println(Thread.currentThread().getName() + " has finished phase 1");
     try {
        cyclicBarrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


        System.out.println(Thread.currentThread().getName() + " is executing phase 2....");
       try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " has finished phase 2");
    try {
        cyclicBarrier.await();
    } catch (InterruptedException | BrokenBarrierException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    
}