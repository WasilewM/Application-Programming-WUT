package com.onibmagairlines.classes;

import com.onibmagairlines.javafx.MainWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Flight{
    private String flightID;
    private String originAirport;
    private String destinationAirport;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private String aircraftId;
    private int freeEcoSeatsNum;
    private int freeBusinessSeatsNum;
    private String captainID;
    private String firstOfficerID;
    private final ArrayList<String> stewardsIds = new ArrayList<>();
    private final ArrayList<String> techniciansIds = new ArrayList<>();

    public Flight(String flightID, String originAirport, String destinationAirport,
                  Timestamp departureTime, Timestamp arrivalTime, String aircraftId) {
        setFlightNumber(flightID);
        setOriginAirport(originAirport);
        setDestinationAirport(destinationAirport);
        setDepartureTime(departureTime);
        setArrivalTime(arrivalTime);
        setAircraftId(aircraftId);
        loadCrew();
    }

    private void loadCrew() {
        Map<Integer, String> positions = Utils.getPositionsMap();
        String query = "SELECT C." + String.join(", C.", Crewmember.getDatabaseFields());
        query += " FROM " + Crewmember.getDatabaseTableName() + " C ";
        query += "JOIN FLIGHTS_CREW FC on C.PERSON_ID = FC.CREWMEMBER_ID " + "WHERE FC.FLIGHT_ID='" + flightID + "'";
        ArrayList<Crewmember> crewmembers = Crewmember.createMultipleObjectsFromList(MainWindow.getDatabase().executeQuery(query));
        for (Crewmember cm : crewmembers) {
            switch (positions.get(cm.getRoleInt())) {
                case "captain" -> captainID = cm.getPersonId();
                case "first officer" -> firstOfficerID = cm.getPersonId();
                case "steward" -> stewardsIds.add(cm.getPersonId());
                case "technician" -> techniciansIds.add(cm.getPersonId());
            }
        }
    }
    public StringProperty originAirportProperty() {
        return new SimpleStringProperty(Utils.getAirportsMap(false).get(originAirport));
    }
    public StringProperty destinationAirportProperty() {
        return new SimpleStringProperty(Utils.getAirportsMap(false).get(destinationAirport));
    }
    public StringProperty aircraftProperty() {
        return new SimpleStringProperty(Utils.getAircraftsMap().get(aircraftId));
    }

    // getters
    public String getFlightID() {
        return flightID;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public int getFreeEcoSeatsNum() {
        return freeEcoSeatsNum;
    }

    public int getFreeBusinessSeatsNum() {
        return freeBusinessSeatsNum;
    }

    public String getCaptainID() {
        return captainID;
    }

    public String getFirstOfficerID() {
        return firstOfficerID;
    }

    public ArrayList<String> getStewardsIds() {
        return stewardsIds;
    }

    public ArrayList<String> getTechniciansIds() {
        return techniciansIds;
    }

    // setters
    public void setFlightNumber(String flightID) throws IllegalArgumentException {
        if(flightID.length() > 0 && flightID.length() <= 40) {
            this.flightID = flightID;
        }
        else {
            throw new IllegalArgumentException("FlightID must contain from 1 to maximum of 40 characters");
        }
    }

    public void setOriginAirport(String originAirport) throws IllegalArgumentException {
        if(originAirport.length() == 4) {
            this.originAirport = originAirport;
        }
        else {
            throw new IllegalArgumentException("Origin airport is determined by the ICAO code of the airport (4 letters).");
        }
    }

    public void setDestinationAirport(String destinationAirport) throws IllegalArgumentException {
        if(destinationAirport.length() == 4) {
            this.destinationAirport = destinationAirport;
        }
        else {
            throw new IllegalArgumentException("Destination airport is determined by the ICAO code of the airport (4 letters).");
        }
    }

    public void setDepartureTime(Timestamp departureTime) throws IllegalArgumentException {
        if ((this.getArrivalTime() == null) || (this.getArrivalTime() != null && departureTime.before(this.getArrivalTime()))) {
            this.departureTime = departureTime;
        }
        else {
            throw new IllegalArgumentException("Departure cannot happen after arrival.");
        }
    }

    public void setArrivalTime(Timestamp arrivalTime) throws IllegalArgumentException {
        if ((this.getDepartureTime() == null) || (this.getDepartureTime() != null && arrivalTime.after(this.getDepartureTime()))) {
            this.arrivalTime = arrivalTime;
        }
        else {
            throw new IllegalArgumentException("Arrival cannot happen before Departure.");
        }
    }

    public void setAircraftId(String aircraftId) throws IllegalArgumentException {
        if(aircraftId.length() > 0 && aircraftId.length() <= 40) {
            this.aircraftId = aircraftId;
        }
        else {
            throw new IllegalArgumentException("AircraftId must contain from 1 to maximum of 40 characters.");
        }
    }

    public void setCaptainID(String captainID) throws IllegalArgumentException {
        if (captainID.length() > 0 && captainID.length() <= 40) {
            this.captainID = captainID;
        }
        else {
            throw new IllegalArgumentException("Captain ID must contain from 1 to 40 characters.");
        }
    }

    public void setFirstOfficerID(String firstOfficerID) throws IllegalArgumentException {
        if (firstOfficerID.length() > 0 && firstOfficerID.length() <= 40) {
            this.firstOfficerID = firstOfficerID;
        }
        else {
            throw new IllegalArgumentException("FIrst Officer ID must contain from 1 to 40 characters.");
        }
    }

    public void setFreeBusinessSeatsNum(int newNumber) throws IllegalArgumentException {
        if (newNumber >= 0 && newNumber <= Utils.getMaxBusinessSeatsNum(this.getAircraftId())) {
            this.freeBusinessSeatsNum = newNumber;
        }
        else {
            throw new IllegalArgumentException("Seat number cannot be negative, nor can it be greater that maximum in chosen plane.");
        }
    }

    public void setFreeEcoSeatsNum(int newNumber) throws IllegalArgumentException {
        if (newNumber >= 0 && newNumber <= Utils.getMaxEcoSeatsNum(this.getAircraftId())) {
            this.freeEcoSeatsNum = newNumber;
        }
        else {
            throw new IllegalArgumentException("Seat number cannot be negative, nor can it be greater that maximum in chosen plane.");
        }
    }

    // other methods
    public static String[] getDatabaseFields() {
        return new String[]{"FLIGHT_ID", "ORIGIN_AIRPORT", "DESTINATION_AIRPORT", "DEPARTURE_TIME", "ARRIVAL_TIME", "AIRCRAFT_ID"};
    }

    public static String getDatabaseTableName() {
        return "flights";
    }

    public Object[] getObjectsValues() {
        return new Object[]{getFlightID(), getOriginAirport(), getDestinationAirport(), getDepartureTime(), getArrivalTime(), getAircraftId()};
    }

    public static Flight createOneObjectFromList(ArrayList<Object> list) {
        return new Flight((String) list.get(0),     // flightID
                (String) list.get(1),               // originAirport (ICAO code)
                (String) list.get(2),               // destinationAirport (ICAO code)
                (java.sql.Timestamp) list.get(3),   // departureTime
                (java.sql.Timestamp) list.get(4),   // arrivalTime
                (String) list.get(5));              // aircraftID
    }


    public static ArrayList<Flight> createMultipleObjectsFromList(ArrayList<ArrayList<Object>> list) {
        ArrayList<Flight> objects = new ArrayList<>();
        for (var row : list)
            objects.add(Flight.createOneObjectFromList(row));
        return objects;
    }

    public ArrayList<Object> getFlightData() {
        var data = MainWindow.getDatabase().executeQuery("""
                SELECT F.FLIGHT_ID, F.ARRIVAL_TIME, F.DEPARTURE_TIME,
                       DESTINATION_AIRPORT.ICAO_CODE, DESTINATION_AIRPORT.NAME, DESTINATION_AIRPORT.CITY,
                       ORIGIN_AIRPORT.ICAO_CODE, ORIGIN_AIRPORT.NAME, ORIGIN_AIRPORT.CITY,
                       A.NAME, A.BRAND, A.MODEL
                                
                FROM FLIGHTS F
                         JOIN AIRCRAFTS A on A.AIRCRAFT_ID = F.AIRCRAFT_ID
                         JOIN AIRPORTS DESTINATION_AIRPORT on DESTINATION_AIRPORT.ICAO_CODE = F.DESTINATION_AIRPORT
                         JOIN AIRPORTS ORIGIN_AIRPORT on ORIGIN_AIRPORT.ICAO_CODE = F.ORIGIN_AIRPORT
                WHERE F.FLIGHT_ID = '""" + getFlightID() + "'");
        return data.get(0);
    }
    public String getOccupiedEcoSeats() {
        var data = MainWindow.getDatabase().executeQuery("SELECT SEAT_NUMBER FROM" +
                        " OCCUPIED_ECO_SEATS WHERE FLIGHT_ID = '" + getFlightID() + "'");
        StringBuilder str = new StringBuilder();
        for (var entry : data) {
            str.append(entry.get(0));
            str.append(", ");
        }
        return str.toString();
    }
    public String getOccupiedBusinessSeats() {
        var data = MainWindow.getDatabase().executeQuery("SELECT SEAT_NUMBER FROM" +
                " OCCUPIED_BUSINESS_SEATS WHERE FLIGHT_ID = '" + getFlightID() + "'");
        StringBuilder str = new StringBuilder();
        for (var entry : data) {
            str.append(entry.get(0));
            str.append(", ");
        }
        return str.toString();
    }
    public static ArrayList<ArrayList<Object>> getCrewmembersInfo(ArrayList<String> ids) {
        StringBuilder where = new StringBuilder();
        where.append("PERSON_ID IN (");
        for (var id : ids) {
           where.append("'").append(id).append("', ");
        }
        where = new StringBuilder(where.substring(0, where.length() - 2));
        where.append(")");
        return MainWindow.getDatabase().executeQuery("SELECT FIRST_NAME, LAST_NAME FROM " +
                "CREWMEMBERS WHERE " + where);
    }
}
