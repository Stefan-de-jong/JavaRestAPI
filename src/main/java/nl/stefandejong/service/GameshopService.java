package nl.stefandejong.service;

import nl.stefandejong.model.Game;
import nl.stefandejong.model.Stock;
import nl.stefandejong.repository.GameRepository;
import nl.stefandejong.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class GameshopService {

    private GameRepository gameRepository;
    private StockRepository stockRepository;

    public GameshopService(GameRepository gameRepository, StockRepository stockRepository){
        this.gameRepository = gameRepository;
        this.stockRepository = stockRepository;
    }

    public Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void deleteGame(long id) {
        gameRepository.delete(gameRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    public int getStockValueByGameId(long id) {
        return stockRepository.getStockValueByGameId(id);
    }

    public void deleteStockItem(long id) {
        stockRepository.delete(stockRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    public Iterable<Stock> getAllStock() {
        return stockRepository.findAll();
    }





}
