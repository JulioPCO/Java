package ExecutorsFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class CompletableFutureDemo {
    public static void show(){
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenRunAsync( () -> {
            Thread.currentThread().getName();
            System.out.println("Done");
        });
        future.thenAccept( result -> {
           System.out.println( Thread.currentThread().getName());
           System.out.println(result);
        });

        //Handlling Exceptions
        var future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather");
            throw new IllegalStateException();
        });

        try {
            var temperature = future2.exceptionally(ex -> 1).get(); // exceptionally allow a default value for future; it creates a new variable future
            System.out.println(temperature);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            //e.getCause();
            e.printStackTrace();
        }

        //Transforming results
        var future3 = CompletableFuture.supplyAsync( () -> 20);
        future3
               .thenApply(CompletableFutureDemo::toFahrenheit)
               .thenAccept(f -> System.out.println(f));
            
        
        //Composing completable future
        getUserEmailAsync()
                .thenCompose(CompletableFutureDemo::getPlaylist)
                .thenAccept(playlist ->System.out.println(playlist));

        //Combining Completable Future
        var first = CompletableFuture
                                .supplyAsync(() -> "20USD")
                                .thenApply(usdString -> {
                                    var price1 = usdString.replace("USD","");
                                    return Integer.parseInt(price1);
                                });   
        var second = CompletableFuture.supplyAsync(() -> 0.9);

        first
            .thenCombine(second, (price,exchangeRate) -> price*exchangeRate)
            .thenAccept(result -> System.out.println(result));

        //Waiting for many task
        var first1 = CompletableFuture.supplyAsync(() -> 1);
        var second1 = CompletableFuture.supplyAsync(() -> 2);
        var third1 = CompletableFuture.supplyAsync(() -> 3);

        var all =  CompletableFuture.allOf(first1,second1,third1);
        all.thenRun(() ->{
            try {
                var firstresult = first1.get();
                System.out.println(firstresult);
            } catch (InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("All tasks completed successfully");
        });

        //Waiting for the first task
        var first2 = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 20;
        });
        var second2 = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture.anyOf(first2,second2) // wait for any task to complete, the one that completes first is used.
                         .thenAccept(temp -> System.out.println(temp)); 

        //Handling Timeouts

        var future4 = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 1;
        });

        try {
            var result3 = future4
                        .completeOnTimeout(2, 1, TimeUnit.SECONDS)
                        .get();
            System.out.println(result3);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static int toFahrenheit(int celsius){
        return (int)(celsius * 1.8) +32;
    }
    
    public static CompletableFuture<String> getUserEmailAsync(){
        return         CompletableFuture.supplyAsync(() -> "email");
    }

    public static CompletableFuture<String> getPlaylist(String email){
        return CompletableFuture.supplyAsync( () -> email +  ": playlist");
    }
}
