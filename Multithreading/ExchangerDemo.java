package Multithreading;
import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        // Creating an Exchanger object to exchange Integer objects between two threads
        final Exchanger<Integer> exchanger = new Exchanger<>();

        // Creating Producer and Consumer threads
        Thread producer = new Thread(new Producer(exchanger), "Producer");
        Thread consumer = new Thread(new Consumer(exchanger), "Consumer");

        // Starting both threads
        producer.start();
        consumer.start();
    }
}

class Consumer implements Runnable {
    private final Exchanger<Integer> exchanger;

    public Consumer(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int dataToSend = 5;
        try {
            System.out.println(Thread.currentThread().getName() + " sending data: " + dataToSend);
            // Exchanging data with the Producer thread
            int data = exchanger.exchange(dataToSend);
            System.out.println(Thread.currentThread().getName() + " received data: " + data);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }
}

class Producer implements Runnable {
    private final Exchanger<Integer> exchanger;

    public Producer(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int dataToSend = 6;
        try {
            Thread.sleep(2000); // Simulate some delay in processing
            System.out.println(Thread.currentThread().getName() + " sending data: " + dataToSend);
            // Exchanging data with the Consumer thread
            int data = exchanger.exchange(dataToSend);
            System.out.println(Thread.currentThread().getName() + " received data: " + data);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }
}
