package nl.stefandejong.controller;


import nl.stefandejong.model.Stock;
import nl.stefandejong.service.GameshopService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    private GameshopService service;

    public StockController(GameshopService service){
        this.service = service;
    }

    @RequestMapping(value = "value/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int getStockValueByGameId(@PathVariable long id){
        return service.getStockValueByGameId(id);
    }

    @RequestMapping(value ="{id}", method = RequestMethod.DELETE)
    public void deleteStockItem(@PathVariable long id) {
        service.deleteStockItem(id);
    }

    @RequestMapping(value ="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Stock> getAllStockItems() {
        return service.getAllStock();
    }
}
