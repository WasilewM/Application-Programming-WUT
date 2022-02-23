package com.onibmagairlines.classes;

public class Person {
    public String firstName;
    public String lastName;
    public String personId;

    public Person(String personId, String firstName, String lastName) {
        setPersonId(personId);
        setFirstName(firstName);
        setLastName(lastName);
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonId() {
        return personId;
    }

    // setters
    public void setFirstName(String firstName) throws IllegalArgumentException {
        if(firstName.length() > 0 && firstName.length() <= 40) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("First name must contain from 1 to maximum of 40 characters.");
        }
    }

    public void setLastName(String lastName) throws IllegalArgumentException{
        if(lastName.length() > 0 && lastName.length() <= 40) {
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException("First name must contain from 1 to maximum of 40 characters.");
        }
    }

    public void setPersonId(String personId) {
        if(personId.length() > 0 && personId.length() <= 40) {
            this.personId = personId;
        }
        else {
            throw new IllegalArgumentException("PersonId must contain from 1 to maximum of 40 characters.");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personId='" + personId + '\'' +
                '}';
    }
}