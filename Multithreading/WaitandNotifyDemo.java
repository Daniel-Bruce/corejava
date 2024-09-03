package Multithreading;

public class WaitandNotifyDemo {
    private static final Object lock = new Object();
    private static void one() throws InterruptedException {
        synchronized (lock){
            System.out.println("Inside one method....");
            lock.wait();
            System.out.println("Back again in one method...");
        }
    }

//    When you call the wait in a thread, the current executing thread will pause its execution and release
//    the lock which will allow other threads to acquire it. When a thread calls notify() (or notifyAll()), it signals one (or all) of the waiting
//    threads to wake up. However, the thread that called notify() will continue to hold the lock and finish its execution within the synchronized block.
//    Only after it exits the synchronized block (releases the lock) can the waiting thread(s) reacquire the lock and resume execution.

    private static void two(){
        synchronized (lock){
            System.out.println("Inside two method...");
             lock.notify();
            System.out.println("Still in the two method....");
        }
    }
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread two = new Thread(WaitandNotifyDemo::two);

        one.start();
        two.start();
    }
}

//Difference between wait() and sleep()
//wait() is used in synchronization and inter-thread communication
//while
//sleep() is used for pausing execution of a thread for a specified duration