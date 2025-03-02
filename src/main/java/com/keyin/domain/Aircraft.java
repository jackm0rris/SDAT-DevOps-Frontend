package com.keyin.domain;

import java.util.List;
import java.util.Objects;

public class Aircraft {


    private Long id;
    private String type;
    private int numberOfPassengers;
    private String airlineName;
    private List<Passenger> passengers;
    private Airport airport;

    // Below are the Getter and setter methods for each field

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }


    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }


    public String getAirlineName() {
        return airlineName;
    }


    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }


    public List<Passenger> getPassengers() {
        return passengers;
    }


    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }


    public Airport getAirport() {
        return airport;
    }


    public void setAirport(Airport airport) {
        this.airport = airport;
    }



    // method to represent the Aircraft object as a String
    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", airlineName='" + airlineName + '\'' +
                ", passengers=" + passengers +
                ", airport=" + airport +
                '}';
    }


    // method to compare two Aircraft objects to make sure their equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;
        Aircraft aircraft = (Aircraft) o;

        return Objects.equals(id, aircraft.id) &&
                Objects.equals(type, aircraft.type) &&
                Objects.equals(numberOfPassengers, aircraft.numberOfPassengers) &&
                Objects.equals(airlineName, aircraft.airlineName) &&
                Objects.equals(passengers, aircraft.passengers) &&
                Objects.equals(airport, aircraft.airport);
    }


    // method to generate a hash code based the Aircraft
    @Override
    public int hashCode() {
        return Objects.hash(id, type, numberOfPassengers, airlineName, passengers, airport); // Generate a hash code using all fields
    }
}
