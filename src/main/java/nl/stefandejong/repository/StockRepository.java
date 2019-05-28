package nl.stefandejong.repository;

import nl.stefandejong.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {

    @Query("select s.quantity * g.price from Stock s, Game g where s.game.id = g.id and s.game.id = ?1")
    public int getStockValueByGameId(long id);
}
