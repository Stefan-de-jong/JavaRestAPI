package nl.stefandejong.service;

import nl.stefandejong.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GameshopService {

    List<Game> games = new ArrayList<Game>(
            Arrays.asList(
                    new Game("CS", "Counter Strike", "FPS"),
                    new Game("CSS", "Counter Strike Source", "FPS"),
                    new Game("WC3", "Warcraft III", "RTS")
            )
    );


    public List<Game> getGames() {
        return games;
    }

    public Game getGame(String id) {
        for (Game game : games) {
            if (game.getId().equals(id)){
                return game;
            }
        }
        return null;
    }

    public void addGame(Game game) {
        games.add(game);
    }
}
