package ExercisesJava.MyTube.src.com.mytube;

public class EmailService implements canEmailService {
    @Override
    public void sendEmail(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }
}
