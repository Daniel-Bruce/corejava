package Multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Worker worker = new Worker(5,0);
        Thread producer = new Thread(()->{
            try {
                worker.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(()->{
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
    class Worker {//class worker same as buffer which acts as an intermediary to provide balance between producer and consumer
        private int sequence = 0;
        private final Integer top;
        private final Integer bottom;
        private final List<Integer> conatiner;
        private final Object lock = new Object();

        public Worker(Integer top, Integer bottom) {
            this.top = top;
            this.bottom = bottom;
            this.conatiner = new ArrayList<>();
        }


        public void produce() throws InterruptedException {
            synchronized (lock) {
                while (true) {
                  if (conatiner.size() == top){
                      System.out.println("Container full, wait for items to be removed");
                      lock.wait();
                  }else{
                      System.out.println(sequence + " Sequence added to container...");
                      conatiner.add(sequence++);
                      lock.notify();
                  }
                  Thread.sleep(500);
                }
            }
        }

        public void consume() throws InterruptedException {
            synchronized (lock) {
                while (true) {
                    if (conatiner.size() == bottom) {
                        System.out.println("Container empty, waiting for items to be added");
                        lock.wait();
                    } else {
                        System.out.println(conatiner.removeFirst() + " removed from container");
                        lock.notify();
                    }
                    Thread.sleep(500);
                }
            }
        }
}
