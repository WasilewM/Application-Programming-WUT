package com.onibmagairlines.javafx;

import com.onibmagairlines.classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;


public class MainWindow extends Application {
    private static Database db;
    private static List<Flight> flights;
    private static List<Airport> airports;
    private static List<Aircraft> aircrafts;
    private static List<Crewmember> crewmembers;
    private static List<Passenger> passengers;
    private static List<Ticket> tickets;
    private static List<Position> positions;

    public static List<Flight> getFlights() { return flights; }
    public static List<Airport> getAirports() { return airports; }
    public static List<Aircraft> getAircrafts() { return aircrafts; }
    public static List<Crewmember> getCrewmembers() { return crewmembers; }
    public static List<Passenger> getPassengers() { return passengers; }
    public static List<Ticket> getTickets() { return tickets; }
    public static List<Position> getPositions() { return positions; }
    public static Database getDatabase() { return db; }
    public static void setDatabase(Database new_db) { db = new_db; }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = FXMLLoader.load(getClass().getResource("/MainView.fxml"));
        Scene mainScene = new Scene(mainPane);
        stage.setScene(mainScene);
        stage.setTitle("Onibmag Airlines");
        stage.getIcons().add(new Image("file:src/main/resources/aviation_logo-22.jpg"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        if (db != null) {
            db.closeConnection();
        }
    }

    public static void loadFlightsFromDatabase() {
        flights = Flight.createMultipleObjectsFromList(db.select(Flight.getDatabaseFields(),
                    Flight.getDatabaseTableName()));
    }

    public static void loadAirportsFromDatabase() {
        airports = Airport.createMultipleObjectsFromList(db.select(Airport.getDatabaseFields(),
                Airport.getDatabaseTableName()));
    }

    public static void loadAircraftsFromDatabase() {
        aircrafts = Aircraft.createMultipleObjectsFromList(db.select(Aircraft.getDatabaseFields(),
                Aircraft.getDatabaseTableName()));
    }

    public static void loadCrewmembersFromDatabase() {
        crewmembers = Crewmember.createMultipleObjectsFromList(db.select(Crewmember.getDatabaseFields(),
                Crewmember.getDatabaseTableName()));
    }

    public static void loadPassengersFromDatabase() {
        passengers = Passenger.createMultipleObjectsFromList(db.select(Passenger.getDatabaseFields(),
                Passenger.getDatabaseTableName()));
    }

    public static void loadTicketsFromDatabase() {
        tickets = Ticket.createMultipleObjectsFromList(db.select(Ticket.getDatabaseFields(),
                Ticket.getDatabaseTableName()));
    }

    public static void loadPositionsFromDatabase() {
        positions = Position.createMultipleObjectsFromList(db.select(Position.getDatabaseFields(),
                Position.getDatabaseTableName()));
    }
}
