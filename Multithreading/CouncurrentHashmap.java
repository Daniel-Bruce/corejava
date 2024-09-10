package Multithreading;

import java.util.concurrent.ConcurrentHashMap;

/**
 * CouncurrentHashmap
 */
public class CouncurrentHashmap {

    public static void main(String[] args) {
        ConcurrentHashMap <String, Integer> fruits = new ConcurrentHashMap<>();
        fruits.put("Apple", 1);
        fruits.put("Banana", 2);
        fruits.put("Oranges", 3);

       // fruits.remove("Oranges");

        System.out.println("Initial map: "+ fruits);

      Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                fruits.put("Apple", fruits.get("Apple")+1);
                System.out.println(Thread.currentThread().getName()+" updated Apple "+fruits.get("Apple"));
            }
        });
        
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                fruits.put("Banana", fruits.get("Banana")+1);
                System.out.println(Thread.currentThread().getName()+" updated Banana "+fruits.get("Banana"));
            }
        });

        thread.start();
        thread2.start();

        
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Final map: "+ fruits);


        
      }
}