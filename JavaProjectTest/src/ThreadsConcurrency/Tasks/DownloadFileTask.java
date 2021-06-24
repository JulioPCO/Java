package ThreadsConcurrency.Tasks;

public class DownloadFileTask implements Runnable {



    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Download File: " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Download Complete: " + Thread.currentThread().getName());
    }
    
}
