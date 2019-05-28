package nl.stefandejong.model;

public class Game {
    String id;
    String title;
    String genre;

    public Game(String id, String title, String genre){
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public Game() {}

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }


}
