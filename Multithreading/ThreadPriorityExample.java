package Multithreading;

public class ThreadPriorityExample {
    //Even though main thread has a default priority, it will still be executed first regardless of whether
    //the other thread has a max/higher priority
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Says Hi");

        Thread one = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ " says Hi as well");

        });
        one.setPriority(Thread.MAX_PRIORITY);
        one.start();
    }

    //Further explanation
//    Correct and Clarified Reasoning:
//    Main Thread Start: The main thread, which executes the main() method,
//    always starts first because the JVM begins execution with the main() method in the main thread.
//    This means the main thread is the first thread to execute when a Java program begins.

//    The main thread will start first, as it's the entry point of the program.
//    Even though other threads may have a higher priority, the main thread will typically execute
//    its current task(like the print statement) before the JVM schedules the higher-priority threads.
}
