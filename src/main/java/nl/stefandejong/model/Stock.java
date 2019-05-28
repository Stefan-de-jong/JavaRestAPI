package nl.stefandejong.model;


import javax.persistence.*;

@Entity
public class Stock {

    @OneToOne(cascade = CascadeType.REMOVE)
    private Game game;

    @Id
    @SequenceGenerator(name = "stock_seq", initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
    private long id;

    private int quantity;
    private Stock(){}

    public Stock(Game game, int quantity){
        this.game = game;
        this.quantity = quantity;
    }

    public Game getGame(){
        return game;
    }

    public void setGame(Game game){
        this.game = game;
    }

    public long getId() {
        return id;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "Stock{" +
                "id=" + id +
                ", game=" + game +
                ", quantity=" + quantity +
                '}';
    }

}
