package Streams;

public class Movies {
    private String titles;
    private int likes;
    private Genre genre;

    public Movies(String titles, int likes, Genre genre) {
        this.titles = titles;
        this.likes = likes;
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getTitles() {
        return titles;
    }

    public int getLikes() {
        return likes;
    }

    
}
