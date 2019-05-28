package nl.stefandejong.repository;

import nl.stefandejong.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}
