package Multithreading;

/**
 * SharedCounter
 */
public class SharedCounter {
    public static int count = 0;
    public static synchronized int increment(){
        return count++;
    }
   public static void main(String[] args) {
    Thread one = new Thread(()->{
            for(int i=0;i<100000;i++){
                increment();
                }
            });
    Thread two = new Thread(()->{
        for(int i=0;i<100000;i++){
            increment();
            
          }
    });
     
    one.start();
    two.start();
    try {
        one.join();
        two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            }

            System.out.println("Final count variable:"+count);

   }
}