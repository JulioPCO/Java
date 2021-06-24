package ThreadsConcurrency.Status;

public class DownloadStatus {
    private int totalbytes;

    public int getTotalbytes() {
        return totalbytes;
    }

    public void incrementBytes(){
        totalbytes++;
    }
}
