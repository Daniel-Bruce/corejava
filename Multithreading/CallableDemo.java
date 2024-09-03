package Multithreading;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //with the ExecutorService you can execute/submit threads
        //With submit you can pass either runnable or callable. with callable
        //you'll have to use submit while with runnable you'll use execute
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            Future<Integer> result = service.submit(new TaskDemo());

            System.out.println(result.get(5000,TimeUnit.SECONDS));
            System.out.println("Main thread execution executed!!!");
        }
    }
}

//if you want to return anything from a thread, implement the callable interface
//callable is a generic based class so you'll have to pass the generics of what
//you want to return
class TaskDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 2;
    }
}
