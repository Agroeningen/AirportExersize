package nl.yacht.airportexersize.buisness;

import nl.yacht.airportexersize.model.AirplaneModel;
import nl.yacht.airportexersize.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirplaneManager {

    @Autowired
    private AirplaneRepository airplaneRepository;

    public Iterable<AirplaneModel> getAll() {
        return this.airplaneRepository.findAll();
    }

    public AirplaneModel getOne(Long id) {
        return this.airplaneRepository.findOne(id);
    }

    public AirplaneModel saveOrder(AirplaneModel airplaneModel) {
        return this.airplaneRepository.save(airplaneModel);
    }

    public void deleteOrder(Long id) {
        this.airplaneRepository.delete(id);
    }

}
