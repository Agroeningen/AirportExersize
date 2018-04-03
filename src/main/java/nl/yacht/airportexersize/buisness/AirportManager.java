package nl.yacht.airportexersize.buisness;

import nl.yacht.airportexersize.model.AirplaneModel;
import nl.yacht.airportexersize.model.AirportModel;
import nl.yacht.airportexersize.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirportManager {

    @Autowired
    private AirportRepository airportRepository;


    public Iterable<AirportModel> getAll() {
        return this.airportRepository.findAll();
    }

    public AirportModel getOne(Long id) {
        return this.airportRepository.findOne(id);
    }

    public AirportModel saveAirplane(AirportModel airportModel) {
        return this.airportRepository.save(airportModel);
    }
}
