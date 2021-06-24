package ThreadsConcurrency.Tasks;

import ThreadsConcurrency.Status.DownloadStatusVolatile;

public class DownloadVolatile implements Runnable{
  
    private DownloadStatusVolatile status;

    public DownloadVolatile(DownloadStatusVolatile status) {
        this.status = status;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Download File: " + Thread.currentThread().getName());

        for(int i= 0; i< 1_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
                status.incrementBytes();
        }

        status.done();

        synchronized (status){
            status.notify();
        }
        
        System.out.println("Download Complete: " + Thread.currentThread().getName());
    }
    
}  

