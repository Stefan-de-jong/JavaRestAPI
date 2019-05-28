package nl.stefandejong.controller;


import nl.stefandejong.model.Game;
import nl.stefandejong.service.GameshopService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameshopService service;

    public GameController(GameshopService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> getAllGames() {
        return service.getGames();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Game getGameById(@PathVariable String id) {
        return service.getGame(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addGame(@RequestBody Game game) {
        service.addGame(game);
    }
}

