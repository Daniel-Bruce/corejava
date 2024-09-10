package Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownlatch {
 

    public static void main(String[] args) {
        int numberChefs = 3;
            CountDownLatch countDownlatch = new CountDownLatch(numberChefs);

            new Thread(new Chef("Chef A", "Pizza", countDownlatch)).start();
            new Thread(new Chef("Chef B", "Potato", countDownlatch)).start();
            new Thread(new Chef("Chef C", "Pasta", countDownlatch)).start();

            try {
                countDownlatch.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("All meals are ready! Prepare to serve");
    }
}

class Chef implements Runnable{
    private String name;
    private String dish;
    private final CountDownLatch latch;

    Chef(String name, String dish,CountDownLatch latch) {
        this.dish = dish;
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(name + " is preparing "+ dish);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+ " has finished preparing "+ dish);
        latch.countDown();
    }
}
