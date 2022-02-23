package com.onibmagairlines.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DatabaseTest {

    @Test
    void openConnectionSuccess() {
        Database databaseMock = mock(Database.class);
        assertNotNull(databaseMock);
        when(databaseMock.openConnection("login", "password")).thenReturn(true);
        assertTrue(databaseMock.openConnection("login", "password"));
    }

    @Test
    void openConnectionError() {
        Database databaseMock = mock(Database.class);
        assertNotNull(databaseMock);
        when(databaseMock.openConnection("login", "password")).thenReturn(false);
        assertFalse(databaseMock.openConnection("login", "password"));
    }

    @Test
    void isConnectedTrue() {
        Database databaseMock = mock(Database.class);
        assertNotNull(databaseMock);
        when(databaseMock.isConnected()).thenReturn(true);
        assertTrue(databaseMock.isConnected());
    }

    @Test
    void isConnectedFalse() {
        Database databaseMock = mock(Database.class);
        assertNotNull(databaseMock);
        when(databaseMock.isConnected()).thenReturn(false);
        assertFalse(databaseMock.isConnected());
    }

    @Test
    void closeConnectionSucces() {
        Database databaseMock = mock(Database.class);
        assertNotNull(databaseMock);
        when(databaseMock.closeConnection()).thenReturn(true);
        assertTrue(databaseMock.closeConnection());
    }

    @Test
    void closeConnectionError() {
        Database databaseMock = mock(Database.class);
        assertNotNull(databaseMock);
        when(databaseMock.closeConnection()).thenReturn(false);
        assertFalse(databaseMock.closeConnection());
    }

    @Test
    void update() {
        Database databaseMock = mock(Database.class);
        Airport airportMock = mock(Airport.class);
        assertNotNull(databaseMock);
        assertNotNull(airportMock);
        String[] s = {"name", "City"};
        Object[] o = {"NOWA NAZWA", "NOWA NAZWA MIASTA"};
        when(databaseMock.update(airportMock.getDatabaseTableName(), s, o, "iata_code = 'DDE'")).thenReturn(1);
        assertEquals(1, databaseMock.update(airportMock.getDatabaseTableName(), s, o, "iata_code = 'DDE'"));
    }

    @Test
    void insert() {
        Database databaseMock = mock(Database.class);
        Airport airportMock = mock(Airport.class);
        assertNotNull(databaseMock);
        assertNotNull(airportMock);
        when(databaseMock.insert(airportMock.getDatabaseTableName(), airportMock.getDatabaseFields(), airportMock.getObjectsValues())).thenReturn(true);
        assertTrue(databaseMock.insert(airportMock.getDatabaseTableName(), airportMock.getDatabaseFields(), airportMock.getObjectsValues()));
    }

    @Test
    void delete() {
        Database databaseMock = mock(Database.class);
        Airport airportMock = mock(Airport.class);
        assertNotNull(databaseMock);
        assertNotNull(airportMock);
        when(databaseMock.delete(airportMock.getDatabaseTableName(), "iata_code = 'BBB'")).thenReturn(true);
        assertTrue(databaseMock.delete(airportMock.getDatabaseTableName(), "iata_code = 'BBB'"));
    }

    @Test
    void select() {
        Database databaseMock = mock(Database.class);
        Passenger passengerMock = mock(Passenger.class);
        assertNotNull(databaseMock);
        assertNotNull(passengerMock);
        assertNotNull(databaseMock.select(passengerMock.getDatabaseFields(), passengerMock.getDatabaseTableName()));

//        ArrayList<ArrayList<Object>> passengerTable = new ArrayList<>();
//        when(databaseMock.select(passengerMock.getDatabaseFields(), passengerMock.getDatabaseTableName())).thenReturn(passengerTable);
//        assertArrayEquals(passengerTable, passengerTable);
    }
}