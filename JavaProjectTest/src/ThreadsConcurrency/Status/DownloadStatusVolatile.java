package ThreadsConcurrency.Status;

public class DownloadStatusVolatile {

    private int totalbytes;   
    private Object totalBytesLock = new Object();
    private volatile boolean isDone;

    public int getTotalbytes() {
        return totalbytes;
    }

    
    public void incrementBytes(){
        synchronized(totalBytesLock){
            totalbytes++;
        }
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}

