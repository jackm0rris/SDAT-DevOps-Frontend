package com.keyin.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;
import java.util.Objects;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class Passenger {

    @JsonProperty("id")
    private Long id;


    @JsonProperty("firstName")
    private String firstName;


    @JsonProperty("lastName")
    private String lastName;


    @JsonProperty("phoneNumber")
    private String phoneNumber;


    @JsonProperty("cityId")
    private Long cityId;


    @JsonProperty("aircraft")
    private List<Aircraft> aircraft;


    @JsonProperty("airport")
    private Airport airport;



    // Constructors
    public Passenger() {}

    public Passenger(Long id, String firstName, String lastName, String phoneNumber, Long cityId, List<Aircraft> aircraft, Airport airport) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.cityId = cityId;
        this.aircraft = aircraft;
        this.airport = airport;
    }


    // Getter and setter methods for every field

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Long getCityId() {
        return cityId;
    }


    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }


    public List<Aircraft> getAircraft() {
        return aircraft;
    }


    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }


    public Airport getAirport() {
        return airport;
    }


    public void setAirport(Airport airport) {
        this.airport = airport;
    }




    // Override the toString method to return a string representation of the passenger object
    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityId=" + cityId +
                ", aircraft=" + aircraft +
                ", airport=" + airport +
                '}';
    }



    // Override the equals method to compare two passenger objects to make them equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) &&
                Objects.equals(firstName, passenger.firstName) &&
                Objects.equals(lastName, passenger.lastName) &&
                Objects.equals(phoneNumber, passenger.phoneNumber) &&
                Objects.equals(cityId, passenger.cityId) &&
                Objects.equals(aircraft, passenger.aircraft) &&
                Objects.equals(airport, passenger.airport);
    }



    // Override the hashCode method to generate a hash code based on the passenger fields
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, cityId, aircraft, airport);
    }
}
