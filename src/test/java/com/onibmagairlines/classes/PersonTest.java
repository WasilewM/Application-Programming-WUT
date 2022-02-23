package com.onibmagairlines.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFirstName() {
        Person testPerson = new Person("DAB12", "Jan", "Kowalski");
        assertEquals("Jan", testPerson.getFirstName());
    }

    @Test
    void getLastName() {
        Person testPerson = new Person("DAB12", "Jan", "Kowalski");
        assertEquals("Kowalski", testPerson.getLastName());
    }

    @Test
    void getPersonId() {
        Person testPerson = new Person("DAB12", "Jan", "Kowalski");
        assertEquals("DAB12", testPerson.getPersonId());
    }

    @Test
    void setFirstName() {
        Person testPerson = new Person("DAB12", "Jan", "Kowalski");
        testPerson.setFirstName("Maciej");
        assertEquals("Maciej", testPerson.getFirstName());
    }

    @Test
    void setEmptyFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("124", "", "LastName");
        });

        String expectedMessage = "First name must contain from 1 to maximum of 40 characters.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setToLongFirstName() {
        String firstName = "0123456789012345678901234567890123456789012345678901234567890123456789";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("124", firstName, "LastName");
        });

        String expectedMessage = "First name must contain from 1 to maximum of 40 characters.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setLastName() {
        Person testPerson = new Person("DAB12", "Jan", "Kowalski");
        testPerson.setLastName("Bocian");
        assertEquals("Bocian", testPerson.getLastName());
    }

    @Test
    void setEmptyLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("124", "Kawka", "");
        });

        String expectedMessage = "First name must contain from 1 to maximum of 40 characters.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setToLongLastName() {
        String lastName = "01234567890123456789012345678901234567890";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("124", "Kawka", lastName);
        });

        String expectedMessage = "First name must contain from 1 to maximum of 40 characters.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setPersonId() {
        Person testPerson = new Person("DAB12", "Jan", "Kowalski");
        testPerson.setPersonId("BABA145");
        assertEquals("BABA145", testPerson.getPersonId());
    }

    @Test
    void setEmptyPersonId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("", "Kawka", "Szpak");
        });

        String expectedMessage = "PersonId must contain from 1 to maximum of 40 characters.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setToLongPersonId() {
        String personID = "01234567890123456789012345678901234567890";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person(personID, "Kawka", "Szpak");
        });

        String expectedMessage = "PersonId must contain from 1 to maximum of 40 characters.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}