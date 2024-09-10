package Multithreading;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurentMap {
    public static void main(String[] args) {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Add key-value pairs
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        // Display the initial map
        System.out.println("Initial Map: " + map);

        // Create threads that concurrently modify the map
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                map.put("Apple", map.get("Apple") + 1);
                System.out.println(Thread.currentThread().getName() + " updated Apple: " + map.get("Apple"));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                map.put("Banana", map.get("Banana") + 1);
                System.out.println(Thread.currentThread().getName() + " updated Banana: " + map.get("Banana"));
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final map
        System.out.println("Final Map: " + map);
    }
}

