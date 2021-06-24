package ThreadsConcurrency.Tasks;

import ThreadsConcurrency.Status.DownloadAtomicStatus;

public class DownloadAtomic implements Runnable{
    private DownloadAtomicStatus status;

    public DownloadAtomic(DownloadAtomicStatus status) {
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

    public DownloadAtomicStatus getStatus(){
        return status;
    }
}
