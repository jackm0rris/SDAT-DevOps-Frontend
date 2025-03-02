package com.keyin.http.cli;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.domain.Cities;
import com.keyin.domain.Passenger;
import com.keyin.http.client.RESTClient;

import java.util.List;
import java.util.Scanner;



public class HTTPRestCLIApplication {
    private final RESTClient restClient;


    // Constructor that accepts a RESTClient object to interact with the API
    public HTTPRestCLIApplication(RESTClient restClient) {
        this.restClient = restClient;
    }


    // Main method that runs the CLI application
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // This Displays the menu options in the terminal
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. List Passengers");
            System.out.println("2. List Aircraft");
            System.out.println("3. List Passengers with Aircraft Info");
            System.out.println("4. List Cities with Airport Info");
            System.out.println("5. List Airports for Aircraft Operations");
            System.out.println("6. List Airports Used by Passengers");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            // Each Case based on user's choice
            switch (choice) {
                case 1 -> listPassengers();
                case 2 -> listAircraft();
                case 3 -> listPassengersWithAircraft();
                case 4 -> listCitiesWithAirports();
                case 5 -> listAirportsForAircraftOperations();
                case 6 -> listAirportsUsedByPassengers();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listPassengersWithAircraft() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Passenger ID: ");
        Long passengerId = scanner.nextLong();
        scanner.nextLine();


        // Fetch passenger data from the RESTClient
        Passenger passenger = restClient.getPassengerById(passengerId);
        if (passenger != null) {
            System.out.println("\n--- Passenger with Aircraft ---");
            System.out.printf("ID: %d, Name: %s, Phone: %s%n",
                    passenger.getId(),
                    passenger.getFirstName() + " " + passenger.getLastName(),
                    passenger.getPhoneNumber());


            // List the aircraft associated with the passenger
            List<Aircraft> aircrafts = passenger.getAircraft();
            if (aircrafts != null && !aircrafts.isEmpty()) {
                System.out.println("\nAircraft:");
                aircrafts.forEach(aircraft ->
                        System.out.printf("  ID: %d, Model: %s, Capacity: %d%n",
                                aircraft.getId(), aircraft.getType(), aircraft.getNumberOfPassengers()));
            } else {
                System.out.println("  No aircraft found.");
            }
        } else {
            System.out.println("Passenger not found.");
        }
    }


    private void listCitiesWithAirports() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter City ID: ");
        Long cityId = scanner.nextLong();
        scanner.nextLine();


        // Fetch city data from the RESTClient
        Cities city = restClient.getCitiesById(cityId);
        if (city != null) {
            System.out.println("\n--- City with Airports ---");
            System.out.printf("ID: %d, Name: %s, Population: %d%n",
                    city.getId(), city.getName(), city.getPopulation());


            List<Airport> airports = restClient.getAirportsByCitiesId(city.getId());
            if (airports != null && !airports.isEmpty()) {
                System.out.println("\nAirports:");
                airports.forEach(airport ->
                        System.out.printf("  ID: %d, Name: %s, Code: %s%n",
                                airport.getId(), airport.getName(), airport.getCode()));
            } else {
                System.out.println("  No airports found.");
            }
        } else {
            System.out.println("City not found.");
        }
    }


    // Lists all passengers in system
    private void listPassengers() {
        List<Passenger> passengers = restClient.getPassengers();
        if (passengers != null) {
            System.out.println("\n--- Passengers ---");
            passengers.forEach(passenger ->
                    System.out.printf("ID: %d, Name: %s, Phone: %s%n",
                            passenger.getId(),
                            passenger.getFirstName() + " " + passenger.getLastName(),
                            passenger.getPhoneNumber()));
        } else {
            System.out.println("No passengers found.");
        }
    }


    // Lists all aircraft in the system
    private void listAircraft() {
        List<Aircraft> aircraftList = restClient.getAllAircraft();
        if (aircraftList != null) {
            System.out.println("\n--- Aircraft ---");
            aircraftList.forEach(aircraft ->
                    System.out.printf("ID: %d, Model: %s, Capacity: %d%n",
                            aircraft.getId(), aircraft.getType(), aircraft.getNumberOfPassengers()));
        } else {
            System.out.println("No aircraft found.");
        }
    }


    // Lists airports that support aircraft operations
    private void listAirportsForAircraftOperations() {
        List<Airport> airports = restClient.getAirportsForAircraftOperations();
        if (airports != null) {
            System.out.println("\n--- Airports for Aircraft Operations ---");
            airports.forEach(airport ->
                    System.out.printf("ID: %d, Name: %s, Code: %s%n",
                            airport.getId(), airport.getName(), airport.getCode()));
        } else {
            System.out.println("No airports found for aircraft operations.");
        }
    }


    // Lists airports used by passengers
    private void listAirportsUsedByPassengers() {
        List<Airport> airports = restClient.getAirportsUsedByPassengers();
        if (airports != null) {
            System.out.println("\n--- Airports Used by Passengers ---");
            airports.forEach(airport ->
                    System.out.printf("ID: %d, Name: %s, Code: %s%n",
                            airport.getId(), airport.getName(), airport.getCode()));
        } else {
            System.out.println("No airports found used by passengers.");
        }
    }


    // Main method to start the application
    public static void main(String[] args) {
        RESTClient restClient = new RESTClient("http://localhost:8080");
        HTTPRestCLIApplication cli = new HTTPRestCLIApplication(restClient);
        cli.run();
    }
}