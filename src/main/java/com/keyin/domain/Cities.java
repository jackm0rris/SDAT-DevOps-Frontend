package com.keyin.domain;

import java.util.List;
import java.util.Objects;

// Some Private fields for city details

public class Cities {
    private Long id;
    private String name;
    private String state;
    private int population;
    private List<Airport> airports;
    private List<Passenger> passengers;


    // Constructors

    public Cities() {}

    public Cities(Long id, String name, String state, int population, List<Airport> airports, List<Passenger> passengers) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.population = population;
        this.airports = airports;
        this.passengers = passengers;
    }


    // Getter and setter methods for every field

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }


    // Method to check if two city objects are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cities city = (Cities) o;
        return population == city.population &&
                Objects.equals(id, city.id) &&
                Objects.equals(name, city.name) &&
                Objects.equals(state, city.state);
    }


    // Method to generate a hash code for the city object
    @Override
    public int hashCode() {
        return Objects.hash(id, name, state, population);
    }
}
