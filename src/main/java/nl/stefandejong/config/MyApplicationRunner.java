package nl.stefandejong.config;


import nl.stefandejong.model.Game;
import nl.stefandejong.model.Stock;
import nl.stefandejong.repository.GameRepository;
import nl.stefandejong.repository.StockRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private GameRepository gameRepository;
    private StockRepository stockRepository;

    public MyApplicationRunner(GameRepository gameRepository, StockRepository stockRepository){
        this.gameRepository = gameRepository;
        this.stockRepository = stockRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Files.lines(Paths.get("src/main/resources/games.csv"))
                .forEach(
                        line -> gameRepository.save(
                                new Game(line.split(",")[0],
                                        line.split(",")[1],
                                        line.split(",")[2],
                                        Integer.parseInt(line.split(",")[3])
                                )
                        )
                );

        gameRepository.findAll()
                .forEach(System.out::println);

        List<Game> games = (List<Game>) gameRepository.findAll();

        games.stream()
                .forEach(g -> stockRepository.save(new Stock(g, new Random().nextInt(10))));

        stockRepository.findAll()
                .forEach(System.out::println);
    }
}
