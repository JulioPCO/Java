package ExercisesJava.MyTube.src.com.mytube;

public class VideoProcessor {
    private canEncoder encoder;
    private canDatabase database;
    private canEmailService emailService;

    public VideoProcessor(
        canEncoder encoder,
        canDatabase database, 
        canEmailService emailService){

        this.encoder = encoder;
        this.database = database;
        this.emailService = emailService;
    }

    public void process(Video video) {
        encoder.encode(video);

        database.store(video);

        emailService.sendEmail(video.getUser());
    }
}

