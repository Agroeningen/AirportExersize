package nl.yacht.airportexersize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AirplaneModel {

    //Values from the created airplane
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private boolean status;
    private int fuel;
    private int passengers;

    //default constructor
    public AirplaneModel() {

    }

    //Constructor, didn't need this one
    public AirplaneModel(Long id, String name, String type, String status, int fuel, int passengers) {
        this.id = id;
        this.name = name;
        this.type = type;

        this.fuel = fuel;
        this.passengers = passengers;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
