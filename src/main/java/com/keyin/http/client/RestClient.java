package com.keyin.http.client;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.domain.Cities;
import com.keyin.domain.Passenger;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RESTClient {
    private static HttpClient httpClient = null; 
    private static ObjectMapper objectMapper = null;
    private static String baseUrl = "";

    // Constructor initializes the HTTP client, ObjectMapper, and sets the base URL
    public RESTClient(String baseUrl) {
        httpClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RESTClient.baseUrl = baseUrl;
    }

    // Returns Instance
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    // Fetching Lists for each aircraft/passenger/airport

    public List<Airport> getAirportsForAircraftOperations() {
        return fetchList("/cities/airports-for-operations", new TypeReference<List<Airport>>() {});
    }

    public Passenger getPassengerById(Long id) {
        return fetchObject("/passengers/" + id, Passenger.class);
    }

    public List<Airport> getAllAirports() {
        return fetchList("/airports", new TypeReference<List<Airport>>() {});
    }

    public List<Airport> getAirportsByCitiesId(Long cityId) {
        return fetchList("/cities/" + cityId + "/airports", new TypeReference<List<Airport>>() {});
    }

    public Cities getCitiesById(Long cityId) {
        return fetchObject("/cities/" + cityId, Cities.class);
    }


    public List<Aircraft> getAllAircraft() {
        return fetchList("/aircrafts", new TypeReference<List<Aircraft>>() {});
    }

    public List<Cities> getAllCities() {
        return fetchList("/cities", new TypeReference<List<Cities>>() {});
    }

    public List<Passenger> getPassengers() {
        return fetchList("/passengers", new TypeReference<List<Passenger>>() {});
    }

    public List<Airport> getAirportsForPassenger(Long passengerId) {
        String endpoint = "/passengers/" + passengerId + "/airports";
        return fetchList(endpoint, new TypeReference<List<Airport>>() {});
    }

    // Helper method to fetch a single object from an endpoint
    private static <T> T fetchObject(String endpoint, Class<T> clazz) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200 && response.body() != null && !response.body().isEmpty()) {
                return objectMapper.readValue(response.body(), clazz);
            } else if (response.statusCode() == 204) {
                System.out.println("No content for the requested resource: " + endpoint);
                return null;
            } else {
                System.err.println("Error (" + response.statusCode() + "): " + response.body());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Exception occurred: " + e.getMessage());
            return null;
        }
    }

    // Helper method to fetch a list of objects from an endpoint
    private <T> List<T> fetchList(String endpoint, TypeReference<List<T>> typeReference) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200 && response.body() != null && !response.body().isEmpty()) {
                return objectMapper.readValue(response.body(), typeReference);
            } else if (response.statusCode() == 204) {
                System.out.println("No content for the requested resource: " + endpoint);
                return List.of();
            } else if (response.statusCode() == 404) {
                System.err.println("Error 404: Resource not found for endpoint: " + endpoint);
                return List.of();
            } else {
                System.err.println("Error (" + response.statusCode() + "): " + response.body());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Exception occurred: " + e.getMessage());
            return null;
        }
    }
}