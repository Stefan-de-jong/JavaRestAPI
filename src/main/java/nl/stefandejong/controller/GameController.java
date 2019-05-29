package nl.stefandejong.controller;


import nl.stefandejong.model.Game;
import nl.stefandejong.service.GameshopService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/games")
public class GameController {

    private GameshopService service;

    public GameController(GameshopService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Game> getAllGames(){
        return service.getAllGames();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addGame(@RequestBody Game game) {
        service.addGame(game);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteGame(@PathVariable long id){
        service.deleteGame(id);
    }


    // ToDo meer soorten requests uitwerken

  /*  @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Game getGameById(@PathVariable String id) {
        return service.getGame(id);
    }*/

/*    @RequestMapping(value = "{genre}")
    public List<Game> getGamesByGenre(@PathVariable String genre) {
        return service.getGamesByGenre(genre);
    }*/

/*    @RequestMapping(value = "{publisher}")
    public List<Game> getGamesByPublisher(@PathVariable String publisher) {
        return service.getGamesByPublisher(publisher);
    }*/


}

