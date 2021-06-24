package ThreadsConcurrency.Tasks;

import ThreadsConcurrency.Status.DownloadStatus;

public class DownloadConfinement  implements Runnable{
    
    private DownloadStatus status;

    public DownloadConfinement() {
        this.status = new DownloadStatus();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Download File: " + Thread.currentThread().getName());

        for(int i= 0; i< 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
                status.incrementBytes();
        }

        System.out.println("Download Complete: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus(){
        return status;
    }
}