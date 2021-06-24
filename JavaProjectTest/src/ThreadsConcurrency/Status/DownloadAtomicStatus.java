package ThreadsConcurrency.Status;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadAtomicStatus {
    private AtomicInteger totalbytes = new AtomicInteger();

    public int getTotalbytes() {
        return totalbytes.get();
    }

    public void incrementBytes(){
        totalbytes.getAndIncrement();
    }
}


