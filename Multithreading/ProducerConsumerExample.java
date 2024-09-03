package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

class Buffer{
    public final Queue<Integer>queue;
    public final Integer maxsize;
    public final Object lock = new Object();

    Buffer(Integer maxsize) {
        this.queue = new LinkedList<>();
        this.maxsize = maxsize;
    }

    public void producer(int value) throws InterruptedException {
        synchronized (lock){
            if (queue.size() == maxsize) {
                System.out.println("Container full waiting for items to be removed");
                lock.wait();
            }else {
                queue.add(value);
                System.out.println("Produced: "+value);
                lock.notify();
            }
            Thread.sleep(500);
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock){
            if (queue.isEmpty()) {
                System.out.println("Container empty waiting for items to be added");
                lock.wait();
            }else {
                int value = queue.poll();
                System.out.println("Consumed: "+value);
                lock.notify();

            }
            Thread.sleep(500);
        }
    }

}

public class ProducerConsumerExample{
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Thread producer = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.producer(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        consumer.start();
        producer.start();
    }
}


