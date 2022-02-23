package com.onibmagairlines.classes;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/*
Due to the fact that method setSeatNumber in class Ticket has been refactored to check whether given number
is no greater than maximum defined in chosen plane, the tests are no longer passing.
Before this refactoring tests worked properly.
*/

class PassengerTest {

    @Test
    void getTicketList() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        Passenger testPassenger = new Passenger("Stefan", "Bogdan", "ABBA1", testTicket);
        ArrayList<Ticket> ticketList = new ArrayList<>();
        ticketList.add(testTicket);
        assertEquals(ticketList, testPassenger.getTicketList());
    }

    @Test
    void setTicketList() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        Ticket newTestTicket = new Ticket("12", "13", "14", 15, "ECO");
        Passenger testPassenger = new Passenger("Stefan", "Bogdan", "ABBA1", testTicket);
        ArrayList<Ticket> ticketList = new ArrayList<>();
        ticketList.add(newTestTicket);
        testPassenger.setTicketList(ticketList);
        assertEquals(ticketList, testPassenger.getTicketList());
    }

    @Test
    void addTicket() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 12, "ECO");
        Ticket newTestTicket = new Ticket("12", "13", "14", 12, "ECO");
        Passenger testPassenger = new Passenger("Stefan", "Bogdan", "ABBA1", testTicket);
        testPassenger.addTicket(newTestTicket);
        ArrayList<Ticket> ticketList = new ArrayList<>();
        ticketList.add(testTicket);
        ticketList.add(newTestTicket);
        assertEquals(ticketList, testPassenger.getTicketList());
    }
}