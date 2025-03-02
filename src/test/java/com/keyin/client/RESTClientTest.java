package com.keyin.client;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.domain.Cities;
import com.keyin.domain.Passenger;
import com.keyin.http.client.RESTClient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RESTClientTest {


    private RESTClient restClient;


    // This method is run before each test case to set up the environment
    @BeforeEach
    public void setUp() {
        restClient = new RESTClient("http://localhost:8080/api");
    }

    // Below is Each Testing method to make sure we can successfully fetch all cities, airports, etc by specific ID or names.
    
    @Test
    public void testGetAllAirports() {
        List<Airport> airports = restClient.getAllAirports();
        assertNotNull(airports);
    }


    @Test
    public void testGetAllCities() {
        List<Cities> cities = restClient.getAllCities();
        assertNotNull(cities);
    }

    @Test
    public void testGetAirportsByCityId() {
        List<Airport> airports = restClient.getAirportsByCitiesId(1L);
        assertNotNull(airports);
    }

    @Test
    public void testGetAllAircraft() {
        List<Aircraft> aircraft = restClient.getAllAircraft();
        assertNotNull(aircraft);
    }

    @Test
    public void testGetPassengers() {
        List<Passenger> passengers = restClient.getPassengers();
        assertNotNull(passengers);
    }
}
