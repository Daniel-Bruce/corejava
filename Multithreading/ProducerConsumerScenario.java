package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerScenario {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 1;

        // Create producer and consumer threads
        Thread producer = new Thread(new Producerrr(queue, maxSize), "Producer");
        Thread consumer = new Thread(new Consumerrr(queue), "Consumer");

        // Start both threads
        producer.start();
        consumer.start();


    }
}

// Consumer class implementing Runnable
class Consumerrr implements Runnable {
    private final Queue<Integer> queue;

    // Constructor to initialize the shared queue
    public Consumerrr(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                // If the queue is empty, wait for the producer to add items
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty, waiting for producer...");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Consumer interrupted");
                    }
                }
                // Consume an item from the queue
                int consumedValue = queue.poll();
                System.out.println("Consumer consumed: " + consumedValue);
                queue.notify();  // Notify the producer that it can produce more
            }
        }
    }
}

// Producer class implementing Runnable
class Producerrr implements Runnable {
    private final Queue<Integer> queue;
    private final int maxSize;
    private static int value = 0;

    // Constructor to initialize the shared queue and max size
    public Producerrr(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                // If the queue is full, wait for the consumer to consume items
                while (queue.size() == maxSize) {
                    System.out.println("Queue is full, waiting for consumer...");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Producer interrupted");
                    }
                }
                // Produce an item and add it to the queue
                queue.add(value);
                System.out.println("Producer produced: " + value);
                value++;
                queue.notify();  // Notify the consumer that it can consume more
            }
        }
    }
}
