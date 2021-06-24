package ExecutorsFramework;

import java.util.concurrent.CompletableFuture;

public class EmailService {
    public void send(){
        LongTask.simulate();
        System.out.println("Mail was sent");
    }

    public CompletableFuture<Void> sendAsync(){
        return CompletableFuture.runAsync(() -> send());
    }
}
