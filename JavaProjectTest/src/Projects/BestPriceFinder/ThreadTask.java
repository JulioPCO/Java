package Projects.BestPriceFinder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ThreadTask {
    public Stream<CompletableFuture<String>> divideTask(){
        var thread = new GettingThread();
        var sites = List.of("1","2","3");


         return sites.stream() 
                .map(n -> thread.getThreads(n));
                
    }
}
