package com.onibmagairlines.classes;

import com.onibmagairlines.javafx.MainWindow;

import java.util.ArrayList;

public class Airport {
    private String IATACode;
    private String ICAOCode;
    private String name;
    private String city;
    private String country;
    private String address;

    public Airport(String IATACode, String ICAOCode, String name, String city, String country, String address)
            throws IllegalArgumentException {
        setIATACode(IATACode);
        setICAOCode(ICAOCode);
        setName(name);
        setCity(city);
        setCountry(country);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public String getIATACode() {
        return IATACode;
    }

    public String getICAOCode() {
        return ICAOCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public void setIATACode(String IATACode) throws IllegalArgumentException {
        if (IATACode.length() == 3)
            this.IATACode = IATACode.toUpperCase();
        else
            throw new IllegalArgumentException("IATA code must contain 3 characters.");
    }

    public void setICAOCode(String ICAOCode) throws IllegalArgumentException {
        if (ICAOCode.length() == 4)
            this.ICAOCode = ICAOCode.toUpperCase();
        else
            throw new IllegalArgumentException("ICAO code must contain 4 characters.");
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.length() >= 3 && name.length() <= 140)
            this.name = name;
        else
            throw new IllegalArgumentException("Airport name must must contain from 3 to a maximum of 140 characters.");
    }

    public void setCity(String city) throws IllegalArgumentException {
        if (city.length() >= 1 && city.length() <= 40)
            this.city = city;
        else
            throw new IllegalArgumentException("City name must contain from 1 to a maximum of 40 characters.");
    }

    public void setCountry(String country) throws IllegalArgumentException {
        if (country.length() >= 4 && country.length() <= 40)
            this.country = country;
        else
            throw new IllegalArgumentException("Country name must contain from 4 to a maximum of 40 characters.");
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (address.length() >= 3 && address.length() <= 40)
            this.address = address;
        else
            throw new IllegalArgumentException("Address must contain from 4 to a maximum of 40 characters.");
    }

    public static String getDatabaseTableName() {
        return "airports";
    }

    public static String[] getDatabaseFields() {
        return new String[]{"iata_code", "icao_code", "name", "city", "country", "address"};
    }

    public Object[] getObjectsValues() {
        return new Object[]{getIATACode(), getICAOCode(), getName(), getCity(), getCountry(), getAddress()};
    }

    public static Airport createOneObjectFromList(ArrayList<Object> list) {
        return new Airport((String) list.get(0),
                (String) list.get(1),
                (String) list.get(2),
                (String) list.get(3),
                (String) list.get(4),
                (String) list.get(5));
    }

    public static ArrayList<Airport> createMultipleObjectsFromList(ArrayList<ArrayList<Object>> list) {
        ArrayList<Airport> objects = new ArrayList<>();
        for (var row : list)
            objects.add(Airport.createOneObjectFromList(row));
        return objects;
    }
    public ArrayList<Flight> getDepartures() {
        String sql = """
                SELECT FLIGHT_ID, ORIGIN_AIRPORT, DESTINATION_AIRPORT, DEPARTURE_TIME, ARRIVAL_TIME, AIRCRAFT_ID
                FROM FLIGHTS
                WHERE ORIGIN_AIRPORT = '""" + getICAOCode() + "'";
        return Flight.createMultipleObjectsFromList(MainWindow.getDatabase().executeQuery(sql));
    }
    public ArrayList<Flight> getArrivals() {
        String sql = """
                SELECT FLIGHT_ID, ORIGIN_AIRPORT, DESTINATION_AIRPORT, DEPARTURE_TIME, ARRIVAL_TIME, AIRCRAFT_ID
                FROM FLIGHTS
                WHERE DESTINATION_AIRPORT = '""" + getICAOCode() + "'";
        return Flight.createMultipleObjectsFromList(MainWindow.getDatabase().executeQuery(sql));
    }

}