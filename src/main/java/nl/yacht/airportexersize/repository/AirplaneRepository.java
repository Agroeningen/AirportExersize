package nl.yacht.airportexersize.repository;

import nl.yacht.airportexersize.model.AirplaneModel;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository<AirplaneModel, Long> {
}
