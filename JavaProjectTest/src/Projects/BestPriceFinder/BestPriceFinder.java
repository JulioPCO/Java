package Projects.BestPriceFinder;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class BestPriceFinder {
    public static void main(String[] args){
        var start = System.nanoTime();

        var tasks = new ThreadTask();

        var tasksThreads = tasks.divideTask()
             .map(future -> future.thenAccept(System.out::println))
             .collect(Collectors.toList());

        var arrayTask =  new CompletableFuture<?>[tasksThreads.size()]; 
        var threads = tasksThreads.toArray(arrayTask);
        
        CompletableFuture
                    .allOf(threads) //or taskThreads.toArrray(new CompletableFuture[0])
                    .thenRun(() -> {
                                    var endtime = System.nanoTime();
                                    System.out.println("Retrieved all Quotes in " + (endtime - start)/ 1000000 + "ms");
                                })
                    .join(); // To join the main thread with the others threads so the program doesn't finish earlier          
    }
}
