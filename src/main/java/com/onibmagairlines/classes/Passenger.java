package com.onibmagairlines.classes;

import com.onibmagairlines.javafx.MainWindow;
import java.util.ArrayList;

public class Passenger extends Person {

    ArrayList<Ticket> ticketList = new ArrayList<>();

    public Passenger(String personId, String firstName, String lastName, Ticket ticket) {
        super(personId, firstName, lastName);
        this.ticketList.add(ticket);
    }

    public Passenger(String personId, String firstName, String lastName, ArrayList<Ticket> ticketList) {
        super(personId, firstName, lastName);
        this.ticketList = ticketList;
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public void addTicket(Ticket newTicket) {
        this.ticketList.add(newTicket);
    }

    public static String getDatabaseTableName() {
        return "passengers";
    }

    public static String[] getDatabaseFields() {
        return new String[]{"PERSON_ID", "FIRST_NAME", "LAST_NAME"};
    }

    public Object[] getObjectsValues() {
        return new Object[]{getPersonId(), getFirstName(), getLastName()};
    }

    public static Passenger createOneObjectFromList(ArrayList<Object> list) {
        ArrayList<Ticket> tickets = Ticket.createMultipleObjectsFromList(MainWindow.getDatabase().select(
                Ticket.getDatabaseFields(), Ticket.getDatabaseTableName(), "PASSENGER_ID = '" + list.get(0) + "'")
        );

        return new Passenger((String) list.get(0),  // personID
                (String) list.get(1),               // firstName
                (String) list.get(2),               // lastName
                tickets);
    }

    public static ArrayList<Passenger> createMultipleObjectsFromList(ArrayList<ArrayList<Object>> list) {
        ArrayList<Passenger> objects = new ArrayList<>();
        for (var row : list)
            objects.add(Passenger.createOneObjectFromList(row));
        return objects;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "ticketList=" + ticketList +
                '}';
    }
}