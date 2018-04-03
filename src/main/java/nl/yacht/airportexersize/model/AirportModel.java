package nl.yacht.airportexersize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AirportModel {

    //values from the airport
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int airplaneSpace;
    private int storedFuel;

    //Default constructor
    public AirportModel() {

    }

    //Constructor
    public AirportModel(Long id, String name, int airplaneSpace, int storedFuel) {
        this.id = id;
        this.name = name;
        this.airplaneSpace = airplaneSpace;
        this.storedFuel = storedFuel;
    }

    //Get and set methods
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAirplaneSpace() {
        return airplaneSpace;
    }

    public void setAirplaneSpace(int airplaneSpace) {
        this.airplaneSpace = airplaneSpace;
    }

    public int getStoredFuel() {
        return storedFuel;
    }

    public void setStoredFuel(int storedFuel) {
        this.storedFuel = storedFuel;
    }




}
