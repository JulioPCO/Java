package ThreadsConcurrency.Status;


import java.util.concurrent.atomic.LongAdder;

public class DownloadAdderStatus {
    private LongAdder totalbytes = new LongAdder();

    public int getTotalbytes() {
        return totalbytes.intValue();
    }

    public void incrementBytes(){
        totalbytes.increment();
    }
}
