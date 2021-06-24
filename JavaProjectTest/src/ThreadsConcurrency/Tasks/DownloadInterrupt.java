package ThreadsConcurrency.Tasks;

public class DownloadInterrupt implements Runnable {

    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Download File: " + Thread.currentThread().getName());

        for(int i= 0; i< Integer.MAX_VALUE; i++) {
            if (Thread.currentThread().isInterrupted()) return;
                System.out.println("Download byte: " + i);
        }

        System.out.println("Download Complete: " + Thread.currentThread().getName());
    }
    
}
