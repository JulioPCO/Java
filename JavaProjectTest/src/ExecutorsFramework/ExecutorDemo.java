package ExecutorsFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class ExecutorDemo {
    public static void show(){
        var executor = Executors.newFixedThreadPool(2);
        System.out.println(executor.getClass().getName());
        
        // Executor example
        try{
           executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        finally{
            executor.shutdown();
        }

        //Callable
        try{
            var future = executor.submit(() -> {
                 LongTask.simulate();
                 return 1;
             });

             System.out.println("Do more work");

             try {
                var result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         }
         finally{
             executor.shutdown();
         }

         //Asynchronous programming

         //CompletableFuture
         Runnable task = () -> System.out.println("a");
         var future = CompletableFuture.runAsync(task);

         try {
            future.get();
        } catch (InterruptedException | ExecutionException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

         Supplier<Integer> task2 = () -> 1; 
         var future2 = CompletableFuture.supplyAsync(task2);
         
         try {
            var result2 = future2.get();
            System.out.println(result2);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
