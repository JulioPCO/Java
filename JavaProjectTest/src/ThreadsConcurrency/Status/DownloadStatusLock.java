package ThreadsConcurrency.Status;

//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatusLock {
    private int totalbytes;
    //private Lock lock = new ReentrantLock();
    private Object totalBytesLock = new Object();

    public int getTotalbytes() {
        return totalbytes;
    }

    public void incrementBytes(){
        /* lock.lock();
        try{ // Not necessary in this case, but for best practice
            totalbytes++;
        }
        finally{
            lock.unlock();
        } */
        
        //or
        synchronized(totalBytesLock){
            totalbytes++;
        }
    }
}
