package nl.stefandejong.model;


import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
public class Game {

    @OneToOne
    private Stock stock;

    @Id
    @SequenceGenerator(name = "game_seq", initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    long id;
    String title;
    String publisher;
    String genre;
    int price;

    public Game(String title, String publisher, String genre, int price){
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.price = price;
    }

    public Game() {}

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", price='" + price + '\'' +
                '}';
    }


}
