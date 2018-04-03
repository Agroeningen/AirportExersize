package nl.yacht.airportexersize.controller;

import nl.yacht.airportexersize.buisness.AirplaneManager;
import nl.yacht.airportexersize.model.AirplaneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/airplaneData")
public class AirplaneController {

    @Autowired
    private AirplaneManager airplaneManager;

    //Gets alls the elements from the database
    @GetMapping()
    public Iterable<AirplaneModel> getAll() {
        return this.airplaneManager.getAll();
    }

    //Gets one the element from the database
    @GetMapping("{id}")
    public AirplaneModel getOne(@PathVariable long id) {
        return this.airplaneManager.getOne(id);
    }

    //changes elements in the database
    @PostMapping()
    public AirplaneModel saveAirplane(@RequestBody AirplaneModel TestPojoRepository) {
        return this.airplaneManager.saveAirplane(TestPojoRepository);
    }

    //Delete an element in the database
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        this.airplaneManager.deleteOrder(id);
    }
}
