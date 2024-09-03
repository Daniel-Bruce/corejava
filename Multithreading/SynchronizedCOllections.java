package Multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCOllections {
    public static void main(String[] args) throws InterruptedException {
        //ArrayList<Integer> list = new ArrayList<>();
        //We use Collections.synchronized to help us in creating concurrent collection

        //It has its own downside e.g
        // course grained locking - only one collection can access lock at a time
        //limited functionality
        //No fail fast iterators
        //performance overhead
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread one = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread two = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(list.size());
    }
}
