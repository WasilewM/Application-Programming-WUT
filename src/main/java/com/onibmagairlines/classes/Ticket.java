package com.onibmagairlines.classes;

import com.onibmagairlines.javafx.MainWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Ticket {
    private String ticketID;
    private String passengerID;
    private String flightID;
    private int seatNumber;
    private String seatClass;

    public Ticket(String ticketID, String passengerID, String flightID,
                  int seatNumber, String seatClass) {
        setTicketID(ticketID);
        setPassengerID(passengerID);
        setFlightID(flightID);
        setSeatClass(seatClass);
        setSeatNumber(seatNumber);
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) throws IllegalArgumentException{
        if(ticketID.length() > 0 && ticketID.length() <= 40) {
            this.ticketID = ticketID;
        }
        else {
            throw new IllegalArgumentException("Ticket ID must contain from 1 to 40 characters.");
        }
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerId) throws IllegalArgumentException {
        if(passengerId.length() > 0 && passengerId.length() <= 40) {
            this.passengerID = passengerId;
        }
        else {
            throw new IllegalArgumentException("Passenger ID must contain from 1 to 40 characters.");
        }
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) throws IllegalArgumentException {
        if(flightID.length() > 0 && flightID.length() <= 40) {
            this.flightID = flightID;
        }
        else {
            throw new IllegalArgumentException("Flight ID must contain from 1 to 40 characters.");
        }
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) throws IllegalArgumentException {
        boolean isValid = false;

        for (var flight: MainWindow.getFlights()) {
            if (flight.getFlightID().equals(this.getFlightID())) {
                if (seatNumber >= 0 && seatNumber <= Utils.getMaxBusinessSeatsNum(flight.getAircraftId())) {
                    this.seatNumber = seatNumber;
                    isValid = true;
                }
            }
        }

        if (!isValid) {
            throw new IllegalArgumentException("Seat number cannot be negative nor can it be grater that maximum in chosen plane.");
        }
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) throws IllegalArgumentException {
        if (seatClass.equals("ECO") || seatClass.equals("BUSINESS")) {
            this.seatClass = seatClass;
        }
        else {
            throw new IllegalArgumentException("Seat class can only be \"ECO\" or \"BUSINESS\".");
        }
    }

    public static String getDatabaseTableName() {
        return "tickets";
    }

    public static String[] getDatabaseFields() {
        return new String[]{"TICKET_ID", "PASSENGER_ID", "FLIGHT_ID", "SEAT_NUMBER", "SEAT_CLASS"};
    }

    public Object[] getObjectsValues() {
        return new Object[]{getTicketID(), getPassengerID(), getFlightID(), getSeatNumber(), getSeatClass()};
    }

    public ArrayList<Object> getTicketData() {
        var data = MainWindow.getDatabase().executeQuery("""
                SELECT F.FLIGHT_ID, F.ARRIVAL_TIME, F.DEPARTURE_TIME,
                       DESTINATION_AIRPORT.ICAO_CODE, DESTINATION_AIRPORT.NAME, DESTINATION_AIRPORT.CITY,
                       ORIGIN_AIRPORT.ICAO_CODE, ORIGIN_AIRPORT.NAME, ORIGIN_AIRPORT.CITY,
                       A.NAME, A.BRAND, A.MODEL,
                       T.SEAT_NUMBER, T.SEAT_CLASS,
                       P.FIRST_NAME, P.LAST_NAME

                       FROM FLIGHTS F
                    JOIN TICKETS T on F.FLIGHT_ID = T.FLIGHT_ID
                    JOIN PASSENGERS P on P.PERSON_ID = T.PASSENGER_ID
                    JOIN AIRCRAFTS A on A.AIRCRAFT_ID = F.AIRCRAFT_ID
                    JOIN AIRPORTS DESTINATION_AIRPORT on DESTINATION_AIRPORT.ICAO_CODE = F.DESTINATION_AIRPORT
                    JOIN AIRPORTS ORIGIN_AIRPORT on ORIGIN_AIRPORT.ICAO_CODE = F.ORIGIN_AIRPORT
                WHERE TICKET_ID = '""" + ticketID + "'");
        return data.get(0);
    }

    public StringProperty passengerProperty() {
        return new SimpleStringProperty(Utils.getPassengersMap().get(passengerID));
    }

    public StringProperty flightProperty() {
        return new SimpleStringProperty(Utils.getFlightsMap(true).get(flightID));
    }

    public static Ticket createOneObjectFromList(ArrayList<Object> list) {
        return new Ticket((String) list.get(0),         // ticketID
                (String) list.get(1),                   // passengerID
                (String) list.get(2),                   // flightID
                (list.get(3).getClass() == java.math.BigDecimal.class ? (((BigDecimal) list.get(3)).intValue()) : Integer.parseInt((String) list.get(3))),
                (String) list.get(4));                  // seatClass - "ECO" or "BUSINESS"
    }

    public static ArrayList<Ticket> createMultipleObjectsFromList(ArrayList<ArrayList<Object>> list) {
        ArrayList<Ticket> objects = new ArrayList<>();
        for (var row : list)
            objects.add(Ticket.createOneObjectFromList(row));
        return objects;
    }
}
