package com.onibmagairlines.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.onibmagairlines.javafx.MainWindow;

public class Utils {
    public static Map<Integer, String> getPositionsMap(){
        Map<Integer, String> positions = new HashMap<Integer, String>();
        for (var row : MainWindow.getPositions()) {
            positions.put(row.getPositionID(), row.getPositionName());
        }

        return positions;
    }

    public  static Map<String, String> getPassengersMap() {
        Map<String, String> passengersMap = new HashMap<String, String>();
        for (var row : MainWindow.getPassengers()) {
            passengersMap.put(row.getPersonId(), row.getPersonId() + ": " +  row.getLastName() + " " + row.getFirstName());
        }

        return passengersMap;
    }

    public static Map<String, String> getAircraftsMap() {
        Map<String, String> aircraftsMap = new HashMap<>();
        for (var row: MainWindow.getAircrafts()) {
            aircraftsMap.put(row.getAircraftId(), row.getAircraftId() + " - " + row.getAircraftModel());
        }

        return aircraftsMap;
    }

    public static Map<String, String> getFlightsMap(boolean longVersion) {
        Map<String, String> flightsMap = new HashMap<>();
        Map<String, String> airportsMap = getAirportsMap(true);
        for (var row : MainWindow.getFlights()) {
            if(longVersion){
                flightsMap.put(row.getFlightID(), row.getFlightID() + "  -  From: " + airportsMap.get(row.getOriginAirport())  +
                        " To: " + airportsMap.get(row.getDestinationAirport()) + " Departure: " + row.getDepartureTime());
            }
            else {
                flightsMap.put(row.getFlightID(), row.getFlightID() + ": " + row.getOriginAirport() + " - " + row.getDestinationAirport());
            }
        }
        return flightsMap;
    }

    public static Map<String, String> getTicketsMap() {
        Map<String, String> ticketsMap = new HashMap<>();
        for (var row : MainWindow.getTickets()) {
            ticketsMap.put(row.getTicketID(), row.getTicketID() + ": passenger: " + row.getPassengerID() + " - flight: " + row.getFlightID());
        }
        return ticketsMap;
    }

    public static Map<String, String> getAirportsMap(boolean isCityNeeded) {
        Map<String, String> airportsMap = new HashMap<>();
        for (var row: MainWindow.getAirports()) {
            if (isCityNeeded){
                airportsMap.put(row.getICAOCode(), row.getICAOCode() + " (" + row.getCity() + ")");
            }
            else{
                airportsMap.put(row.getICAOCode(), row.getICAOCode() + " - " + row.getName());
            }
        }

        return airportsMap;
    }

    public static Map<String, String> getCrewmembersMap() {
        Map<String, String> crewmembersMap = new HashMap<>();
        for (var row : MainWindow.getCrewmembers()) {
            crewmembersMap.put(row.getPersonId(), row.getPersonId() + ": " + row.getLastName() + " - " + row.getFirstName());
        }

        return crewmembersMap;
    }

    public static int getMaxEcoSeatsNum(String aircraftID) {
        int maxSeatsNum = 0;

        MainWindow.loadAircraftsFromDatabase();     // refresh info stored in program
        for (var row : MainWindow.getAircrafts()) {
            if (row.getAircraftId().equals(aircraftID)) {
                maxSeatsNum = row.getSeatsAvailableEco();
            }
        }

        return maxSeatsNum;
    }

    public static int getMaxBusinessSeatsNum(String aircraftID) {
        int maxSeatsNum = 0;

        MainWindow.loadAircraftsFromDatabase();     // refresh info stored in program
        for (var row : MainWindow.getAircrafts()) {
            if (row.getAircraftId().equals(aircraftID)) {
                maxSeatsNum = row.getSeatsAvailableEco();
            }
        }

        return maxSeatsNum;
    }
}
