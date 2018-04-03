package nl.yacht.airportexersize.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AirplaneModel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private String status;
    private int fuel;
    private int passengers;


    public AirplaneModel() {

    }

    public AirplaneModel(Long id, String name, String type, String status, int fuel, int passengers) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.fuel = fuel;
        this.passengers = passengers;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
