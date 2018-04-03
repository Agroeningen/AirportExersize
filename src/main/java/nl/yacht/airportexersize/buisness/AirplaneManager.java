package nl.yacht.airportexersize.buisness;

import nl.yacht.airportexersize.model.AirplaneModel;
import nl.yacht.airportexersize.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

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

    public AirplaneModel saveAirplane(AirplaneModel airplaneModel) {
        return this.airplaneRepository.save(airplaneModel);
    }

    public void deleteOrder(Long id) {
        this.airplaneRepository.delete(id);
    }

    @PostConstruct
    private void createTestData() {
        Random rand = new Random();
        for (int i = 0; i < 15; ++i) {
            //rand = Math.floor(Math.rand() * 100);
            AirplaneModel airplaneModel = new AirplaneModel();
            airplaneModel.setStatus("onGround");
            airplaneModel.setName("Airplane " + i);
            airplaneModel.setFuel(100);
            airplaneModel.setPassengers(101);

            this.saveAirplane(airplaneModel);
        }
    }
}
