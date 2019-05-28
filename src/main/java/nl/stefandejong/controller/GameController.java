package nl.stefandejong.controller;


import nl.stefandejong.model.Game;
import nl.stefandejong.service.GameshopService;
import org.springframework.http.HttpStatus;
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
    public List<Game> getAllGames(@RequestParam(required = false) boolean sorted,
                                  @RequestParam(required = false, defaultValue = "0")int minimum,
                                  @RequestParam(required = false, defaultValue = "" + Integer.MAX_VALUE) int pageSize) {
        return service.getGames(sorted, minimum, pageSize);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Game getGameById(@PathVariable String id) {
        return service.getGame(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addGame(@RequestBody Game game) {
        service.addGame(game);
    }

    @RequestMapping(value = "{genre}")
    public List<Game> getGamesByGenre(@PathVariable String genre) {
        return service.getGamesByGenre(genre);
    }

    @RequestMapping(value = "{publisher}")
    public List<Game> getGamesByPublisher(@PathVariable String publisher) {
        return service.getGamesByPublisher(publisher);
    }
}

