package com.onibmagairlines.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Due to the fact that method setSeatNumber in class Ticket has been refactored to check whether given number
is no greater than maximum defined in chosen plane, the tests are no longer passing.
Before this refactoring tests worked properly.
*/

class TicketTest {

    @Test
    void getNumber() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        assertEquals("BAD12", testTicket.getTicketID());
    }

    @Test
    void setNumber() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        testTicket.setTicketID("BAC12");
        assertEquals("BAC12", testTicket.getTicketID());
    }

    @Test
    void getPassengerId() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        assertEquals("BAD13", testTicket.getPassengerID());
    }

    @Test
    void setPassengerId() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        testTicket.setPassengerID("BAD14");
        assertEquals("BAD14", testTicket.getPassengerID());
    }

    @Test
    void getFlightNumber() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        assertEquals("BAD14", testTicket.getFlightID());
    }

    @Test
    void setFlightNumber() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        testTicket.setFlightID("BAC12");
        assertEquals("BAC12", testTicket.getFlightID());
    }

    @Test
    void getSeatNumber() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        assertEquals(15, testTicket.getSeatNumber());
    }

    @Test
    void setSeatNumber() {
        Ticket testTicket = new Ticket("BAD12", "BAD13", "BAD14", 15, "ECO");
        testTicket.setSeatNumber(16);
        assertEquals(16, testTicket.getSeatNumber());
    }
}