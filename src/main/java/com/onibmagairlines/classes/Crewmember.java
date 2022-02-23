package com.onibmagairlines.classes;


import com.onibmagairlines.javafx.MainWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Crewmember extends Person {

    int roleInt;

    public Crewmember(String personId, String firstName, String lastName, int role) {
        super(personId, firstName, lastName);
        setRole(role);
    }

    // setters
    public void setRole(int roleInt) throws IllegalArgumentException {
        boolean isRoleFound = false;
        for (var row : MainWindow.getPositions()) {
            if (row.getPositionID() == roleInt) {
                isRoleFound = true;
                this.roleInt = roleInt;
            }
        }

        if (!isRoleFound) {
            throw new IllegalArgumentException("Role must be chosen from provided list of positions.");
        }
    }

    // getters
    public int getRoleInt() {
        return roleInt;
    }

    public StringProperty roleProperty() {
        return new SimpleStringProperty(Utils.getPositionsMap().get(roleInt));
    }

    @Override
    public String toString() {
        return "Crewmember{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", personId='" + super.getPersonId() + '\'' +
                ", role=" + Utils.getPositionsMap().get(roleInt) +
                '}';
    }

    public static String getDatabaseTableName() {
        return "crewmembers";
    }

    public static String[] getDatabaseFields() {
        return new String[]{"PERSON_ID", "FIRST_NAME", "LAST_NAME", "POSITION_ID"};
    }

    public Object[] getObjectsValues() {
        return new Object[]{getPersonId(), getFirstName(), getLastName(), getRoleInt()};
    }

    public static Crewmember createOneObjectFromList(ArrayList<Object> list) {
        return new Crewmember((String) list.get(0),     // personID
                (String) list.get(1),                   // firstName
                (String) list.get(2),                   // lastName
                ((list.get(3).getClass() == java.math.BigDecimal.class ? (((BigDecimal) list.get(3)).intValue()) : (Integer) list.get(3))));    // role
    }

    public static ArrayList<Crewmember> createMultipleObjectsFromList(ArrayList<ArrayList<Object>> list) {
        ArrayList<Crewmember> objects = new ArrayList<>();
        for (var row : list)
            objects.add(Crewmember.createOneObjectFromList(row));
        return objects;
    }
    public ArrayList<Flight> getFlights() {
        String sql = """
                SELECT F.FLIGHT_ID, F.ORIGIN_AIRPORT, F.DESTINATION_AIRPORT, F.DEPARTURE_TIME, F.ARRIVAL_TIME, F.AIRCRAFT_ID
                FROM FLIGHTS F
                    JOIN FLIGHTS_CREW FC on F.FLIGHT_ID = FC.FLIGHT_ID
                    JOIN CREWMEMBERS C on C.PERSON_ID = FC.CREWMEMBER_ID
                WHERE C.PERSON_ID = '""" + getPersonId() + "'";
        return Flight.createMultipleObjectsFromList(MainWindow.getDatabase().executeQuery(sql));
    }
}
