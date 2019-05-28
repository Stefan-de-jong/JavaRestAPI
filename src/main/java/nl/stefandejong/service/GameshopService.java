package nl.stefandejong.service;

import nl.stefandejong.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GameshopService {

    private List<Game> games = new ArrayList<Game>(
            Arrays.asList(
                    new Game("CS", "Counter Strike", "Valve", "FPS", 5),
                    new Game("CSS", "Counter Strike Source", "Valve", "FPS", 10),
                    new Game("WC3", "Warcraft III", "Blizzard","RTS", 15),
                    new Game("LOL", "League of Legends","Riot" ,"MOBA", 0)
            )
    );


    public List<Game> getGames(boolean sorted, final int minimum, int pageSize) {
        Stream<Game> gameStream = games.stream()
                .filter(game -> game.getPrice() >= minimum);

        if(sorted){
            gameStream = gameStream
                    .sorted(Comparator.comparingInt(Game::getPrice));
        }

        return gameStream
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public Game getGame(String id) {
        return games.stream()
                .filter(game -> game.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public List<Game> getGamesByGenre(String genre){
        return games.stream()
                .filter(game -> game.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    public List<Game> getGamesByPublisher(String publisher){
        return games.stream()
                .filter(game -> game.getPublisher().equals(publisher))
                .collect(Collectors.toList());
    }
}
