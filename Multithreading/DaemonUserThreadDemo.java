package Multithreading;

public class DaemonUserThreadDemo {
    public static void main(String[] args) {
        Thread one = new Thread(new DaemonExample());
        Thread two = new Thread(new UsrThread());

        one.setDaemon(true);
        one.start();
        two.start();
        System.out.println("Main thread execution");
    }
}

class DaemonExample implements Runnable{
    @Override
    public void run() {
        int count = 0;
        while(count < 500){
            count ++;
        try {
            Thread.sleep(1000);
            System.out.println("Daemon thread running ...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}}

class UsrThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Usr thread finished execution ...");
    }
}
