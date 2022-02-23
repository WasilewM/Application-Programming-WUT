package com.onibmagairlines.classes;

import com.onibmagairlines.javafx.MainWindow;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Aircraft {
    private String aircraftId;
    private String aircraftName;
    private String aircraftBrand;
    private String aircraftModel;

    private int seatsAvailableEco;
    private int seatsAvailableBus;

    public Aircraft(String aircraftId, String aircraftName, String aircraftBrand, String aircraftModel, int _seatsAvailableEco, int _seatsAvailableBus) {
        setAircraftId(aircraftId);
        setAircraftName(aircraftName);
        setAircraftBrand(aircraftBrand);
        setAircraftModel(aircraftModel);
        setSeatsAvailableEco(_seatsAvailableEco);
        setSeatsAvailableBus(_seatsAvailableBus);
    }

    public void setSeatsAvailableEco(int numSeats) throws IllegalArgumentException {
        if (numSeats >= 0) {
            this.seatsAvailableEco = numSeats;
        }
        else {
            throw new IllegalArgumentException("Number of seats cannot be negative.");
        }
    }

    public void setSeatsAvailableBus(int numSeats) throws IllegalArgumentException {
        if (numSeats >= 0) {
            this.seatsAvailableBus = numSeats;
        }
        else {
            throw new IllegalArgumentException("Number of seats cannot be negative.");
        }
    }

    public void setAircraftBrand(String planeBrand) throws IllegalArgumentException {
        if(planeBrand.length() > 0 && planeBrand.length() <= 40) {
            this.aircraftBrand = planeBrand;
        }
        else {
            throw new IllegalArgumentException("Brand name must contain from 1 to maximum of 40 characters.");
        }
    }

    public void setAircraftName(String planeName) throws IllegalArgumentException {
        if(planeName.length() > 0 && planeName.length() <= 40) {
            this.aircraftName = planeName;
        }
        else {
            throw new IllegalArgumentException("Plane name must contain from 1 to maximum of 40 characters.");
        }
    }

    public void setAircraftModel(String planeModel) throws IllegalArgumentException {
        if(planeModel.length() > 0 && planeModel.length() <= 40) {
            this.aircraftModel = planeModel;
        }
        else {
            throw new IllegalArgumentException("Aircraft model must contain from 1 to maximum of 40 characters.");
        }
    }

    public void setAircraftId(String aircraftId) throws IllegalArgumentException {
        if(String.valueOf(aircraftId).length() > 0 && String.valueOf(aircraftId).length() <= 40) {
            this.aircraftId = aircraftId;
        }
        else {
            throw new IllegalArgumentException("AircraftId must contain from 1 to maximum of 40 characters.");
        }
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public String getAircraftBrand() {
        return aircraftBrand;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public Integer getSeatsAvailableEco() { return seatsAvailableEco; }

    public Integer getSeatsAvailableBus() { return seatsAvailableBus; }

    public static String getDatabaseTableName() {
        return "aircrafts";
    }

    public static String[] getDatabaseFields() {
        return new String[]{"AIRCRAFT_ID", "NAME", "BRAND", "MAX_ECO_SEATS", "MAX_BUSINESS_SEATS", "MODEL"};
    }

    public Object[] getObjectsValues() {
        return new Object[]{getAircraftId(), getAircraftName(), getAircraftBrand(), getSeatsAvailableEco(), getSeatsAvailableBus(), getAircraftModel()};
    }

    public static Aircraft createOneObjectFromList(ArrayList<Object> list) {
        return new Aircraft((String) list.get(0),  // aircraftId
                (String) list.get(1),           // aircraftName
                (String) list.get(2),           // aircraftBrand
                (String) list.get(5),           // aircraftModel
                list.get(3).getClass() == java.math.BigDecimal.class ? ((BigDecimal) list.get(3)).intValue() : (Integer) list.get(3),  // available eco class seats
                list.get(4).getClass() == java.math.BigDecimal.class ? ((BigDecimal) list.get(4)).intValue() : (Integer) list.get(4)); // available business class seats
    }

    public static ArrayList<Aircraft> createMultipleObjectsFromList(ArrayList<ArrayList<Object>> list) {
        ArrayList<Aircraft> objects = new ArrayList<>();
        for (var row : list)
            objects.add(Aircraft.createOneObjectFromList(row));
        return objects;
    }
    public ArrayList<Flight> getFlights() {
        String sql = """
                SELECT FLIGHT_ID, ORIGIN_AIRPORT, DESTINATION_AIRPORT, DEPARTURE_TIME, ARRIVAL_TIME, AIRCRAFT_ID
                FROM FLIGHTS F WHERE AIRCRAFT_ID = '""" + getAircraftId() + "'";
        return Flight.createMultipleObjectsFromList(MainWindow.getDatabase().executeQuery(sql));
    }

}
