package nl.stefandejong.config;


import nl.stefandejong.model.ApiKey;
import nl.stefandejong.model.Game;
import nl.stefandejong.model.Stock;
import nl.stefandejong.repository.ApiKeyRepository;
import nl.stefandejong.repository.GameRepository;
import nl.stefandejong.repository.StockRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private GameRepository gameRepository;
    private StockRepository stockRepository;
    private ApiKeyRepository keyRepository;

    public MyApplicationRunner(GameRepository gameRepository, StockRepository stockRepository, ApiKeyRepository apiKeyRepository){
        this.gameRepository = gameRepository;
        this.stockRepository = stockRepository;
        this.keyRepository = apiKeyRepository;
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

        for (String s : Arrays.asList(new String[]{"5962A7199EBCA21A48ABAE8E8921A", "A21896CC68CF6822A8F4A9EC2D6A8", "57CB8558ADF9CE22FEE4DF2A34B86"})) {
            keyRepository.save(new ApiKey(s));
        }

        keyRepository.findAll()
                .forEach(System.out::println);

    }
}
