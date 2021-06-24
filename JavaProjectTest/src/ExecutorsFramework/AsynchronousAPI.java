package ExecutorsFramework;

public class AsynchronousAPI {
    public static void main(String[] args){
        var service = new EmailService();
        service.sendAsync();
        System.out.println("Hello world");

        CompletableFutureDemo.show();
    }
}
