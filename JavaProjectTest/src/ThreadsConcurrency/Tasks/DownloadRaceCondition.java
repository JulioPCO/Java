package ThreadsConcurrency.Tasks;

import ThreadsConcurrency.Status.DownloadStatus;

public class DownloadRaceCondition  implements Runnable{
    
    private DownloadStatus status;

    public DownloadRaceCondition(DownloadStatus status) {
        this.status = status;
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
    
}
