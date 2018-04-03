package nl.yacht.airportexersize.controller;

import nl.yacht.airportexersize.buisness.AirportManager;
import nl.yacht.airportexersize.model.AirplaneModel;
import nl.yacht.airportexersize.model.AirportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/airportData")
public class AirportController {

    @Autowired
    private AirportManager airportManager;

    //Gets alls the elements from the database
    @GetMapping()
    public Iterable<AirportModel> getAll() {
        return this.airportManager.getAll();
    }

    //Gets one the element from the database
    @GetMapping("{id}")
    public AirportModel getOne(@PathVariable long id) {
        return this.airportManager.getOne(id);
    }

    //changes elements in the database
    @PostMapping()
    public AirportModel saveAirplane(@RequestBody AirportModel airportModel) {
        return this.airportManager.saveAirport(airportModel);
    }

    //Delete an element in the database
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        this.airportManager.deleteOrder(id);
    }
}
