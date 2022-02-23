package com.onibmagairlines.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @Test
    void getName() throws IllegalArgumentException {
        Airport testAirport = new Airport("NIS",
                "BXAP",
                "NISKO",
                "Warsaw",
                "Poland",
                "addr");
        assertEquals("NISKO", testAirport.getName());
    }

    @Test
    void getIATACode() throws IllegalArgumentException {
        Airport testAirport = new Airport("NIS",
                "BXAP",
                "Nisko",
                "Warsaw",
                "Poland",
                "addr");
        assertEquals("NIS", testAirport.getIATACode());
    }

    @Test
    void getICAOCode() throws IllegalArgumentException {
        Airport testAirport = new Airport("Nis",
                "BXAP",
                "EPPO",
                "Warsaw",
                "Poland",
                "addr");
        assertEquals("BXAP", testAirport.getICAOCode());
    }

    @Test
    void getCity() throws IllegalArgumentException {
        Airport testAirport = new Airport("Nis",
                "BXAP",
                "EPPO",
                "Warsaw",
                "Poland",
                "addr");
        assertEquals("Warsaw", testAirport.getCity());
    }

    @Test
    void getCountry() throws IllegalArgumentException {
        Airport testAirport = new Airport("Nis",
                "BXAP",
                "EPPO",
                "Warsaw",
                "Poland",
                "addr");
        assertEquals("Warsaw", testAirport.getCity());
    }

    @Test
    void getAddress() throws IllegalArgumentException {
        Airport testAirport = new Airport("Nis",
                "BXAP",
                "EPPO",
                "Warsaw",
                "Poland",
                "addr");
        assertEquals("addr",  testAirport.getAddress());
    }

    @Test
    void setName() {
        Airport testAirport = new Airport("NIS",
                "BXAP",
                "Nisko",
                "Warsaw",
                "Poland",
                "Address");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setName("Na"));
        assertTrue(exception.getMessage().contains("Airport name must must contain from 3 to a maximum of 40 charact" +
                "ers."));

        exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setName("Dkgvzqvgiyendprmouojacazl" +
                "anzljdtsjslakrgawcxlyomvhqrjxwtkppbokrtlxbkmophdsvkkezhgypqcjaatxxpdcjddschlznccydklpkzosfdomlpodwmp" +
                "lqrzxlgqgjhwacuyktjjxbwypxcahfelktcoenfjgufmmbjoeayxhknzlhlywkzpleecnqabxoyxsflylgmmvtzchebjkhhfjctd" +
                "bqxnpoxxmvlzpumvcqlkxhmtvwzrsbqx"));
        assertTrue(exception.getMessage().contains("Airport name must must contain from 3 to a maximum of 40 charact" +
                "ers."));

        assertEquals("Nisko", testAirport.getName());
        testAirport.setName("Name");
        assertEquals("Name",  testAirport.getName());
    }

    @Test
    void setIATACode() {
        Airport testAirport = new Airport("BXP",
                "BXAP",
                "Epoka Lodowcowa",
                "Warsaw",
                "Poland",
                "addr");

        // try to set IATA code shorter than 3 letters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setIATACode("AA"));
        assertTrue(exception.getMessage().contains("IATA code must contain 3 characters."));

        // try to set IATA code longer than 3 letters
        exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setIATACode("AAAAAAA"));
        assertTrue(exception.getMessage().contains("IATA code must contain 3 characters."));

        assertEquals("BXP", testAirport.getIATACode());
        testAirport.setIATACode("EPL");
        assertEquals("EPL", testAirport.getIATACode());
    }

    @Test
    void setICAOCode() {
        Airport testAirport = new Airport("NIS",
                "BXAP",
                "EPPO",
                "Warsaw",
                "Poland",
                "addr");

        // try to set ICAO code shorter 4 letters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setICAOCode("AAA"));
        assertTrue(exception.getMessage().contains("ICAO code must contain 4 characters."));

        // try to set ICAO code longer than 4 letters
        exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setICAOCode("AAAAA"));
        assertTrue(exception.getMessage().contains("ICAO code must contain 4 characters."));

        assertEquals("BXAP", testAirport.getICAOCode());
        testAirport.setICAOCode("EKKO");
        assertEquals("EKKO",  testAirport.getICAOCode());
    }

    @Test
    void setCity() {
        Airport testAirport = new Airport("NIS",
                "BXAP",
                "Nisko",
                "Warsaw",
                "Poland",
                "addr");

        // try to set name shorter than 1 letter
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setCity(""));
        assertTrue(exception.getMessage().contains("City name must contain from 1 to a maximum of 40 characters."));

        // try to set name longer than 40 letters
        exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setCity("12345678901234567890" +
                "qazwsxedcrfvtgbyhnujmikqazwsxedcrfvtgbyhnujmik"));
        assertTrue(exception.getMessage().contains("City name must contain from 1 to a maximum of 40 characters."));

        assertEquals("Warsaw", testAirport.getCity());
        testAirport.setCity("City");
        assertEquals("City",  testAirport.getCity());
    }

    @Test
    void setCountry() {
        Airport testAirport = new Airport("EPP",
                "BXAP",
                "Epoka Lodowcowa",
                "Warsaw",
                "Poland",
                "addr");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setCountry("Abc"));
        assertTrue(exception.getMessage().contains("Country name must contain from 4 to a maximum of 40 characters."));

        exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setCountry(
                "azlanzljdtsjslakrgawcxlyomvhqrjxwtkazlanzljdtsjslakrgawcxlyomvhqrjxwtkazlanzljdtsjslakrgawcxlyomvhqrjxwtk")
        );
        assertTrue(exception.getMessage().contains("Country name must contain from 4 to a maximum of 40 characters."));

        assertEquals("Poland", testAirport.getCountry());
        testAirport.setCountry("Nepal");
        assertEquals("Nepal",  testAirport.getCountry());
    }

    @Test
    void setAddress() {
        Airport testAirport = new Airport("Nis",
                "BXAP",
                "EPPO",
                "Warsaw",
                "Poland",
                "Address");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setAddress("Ab"));
        assertTrue(exception.getMessage().contains("Address must contain from 4 to a maximum of 40 characters."));

        exception = assertThrows(IllegalArgumentException.class, () -> testAirport.setAddress("Dkgvzqvgiyendprmouojac" +
                "azlanzljdtsjslakrgawcxlyomvhqrjxwtkppbokrtlxbkmophdsvkkezhgypqcjaatxxpdcjddschlznccydklpkzosfdomlpod" +
                "wmplqrzxlgqgjhwacuyktjjxbwypxcahfelktcoenfjgufmmbjoeayxhknzlhlywkzpleecnqabxoyxsflylgmmvtzchebjkhhfj" +
                "ctdbqxnpoxxmvlzpumvcqlkxhmtvwzrsbqx"));
        assertTrue(exception.getMessage().contains("Address must contain from 4 to a maximum of 40 characters."));

        assertEquals("Address", testAirport.getAddress());
        testAirport.setAddress("Addr");
        assertEquals("Addr",  testAirport.getAddress());
    }
}
