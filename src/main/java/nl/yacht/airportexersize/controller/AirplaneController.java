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

    @GetMapping()
    public Iterable<AirplaneModel> getAll() {
        return this.airplaneManager.getAll();
    }

    @GetMapping("{id}")
    public AirplaneModel getOne(@PathVariable long id) {
        return this.airplaneManager.getOne(id);
    }

    @PostMapping()
    public AirplaneModel saveOrder(@RequestBody AirplaneModel TestPojoRepository) {
        return this.airplaneManager.saveOrder(TestPojoRepository);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable long id) {
        this.airplaneManager.deleteOrder(id);
    }
}
