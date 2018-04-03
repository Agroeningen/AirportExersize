package nl.yacht.airportexersize.repository;

import nl.yacht.airportexersize.model.AirportModel;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<AirportModel, Long> {
}
