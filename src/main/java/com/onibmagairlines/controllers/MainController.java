package com.onibmagairlines.controllers;

import com.onibmagairlines.classes.*;
import com.onibmagairlines.javafx.MainWindow;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

import java.awt.Desktop;
import java.net.URI;

enum DialogMode {ADD, EDIT}

public class MainController {
    @FXML
    private Button editFlightButton;

    @FXML
    private Button delFlightButton;

    @FXML
    private Button infoFlightButton;

    @FXML
    private TableView<Flight> flightsTable;

    @FXML
    private TableColumn<Flight, String> flightNumCol;

    @FXML
    private TableColumn<Flight, String> flightOriginCol;

    @FXML
    private TableColumn<Flight, String> flightDestinationCol;

    @FXML
    private TableColumn<Flight, DateCell> flightDepartureCol;

    @FXML
    private TableColumn<Flight, DateCell> flightArrivalCol;

    @FXML
    private TableColumn<Flight, String> flightAircraftCol;

    @FXML
    private Button editAirportButton;

    @FXML
    private Button delAirportButton;

    @FXML
    private Button infoAirportButton;

    @FXML
    private TableView<Airport> airportsTable;

    @FXML
    private TableColumn<Airport, String> airportNameCol;

    @FXML
    private TableColumn<Airport, String> airportIataCol;

    @FXML
    private TableColumn<Airport, String> airportIcaoCol;

    @FXML
    private TableColumn<Airport, String> airportCityCol;

    @FXML
    private TableColumn<Airport, String> airportCountryCol;

    @FXML
    private TableColumn<Airport, String> airportAddressCol;

    @FXML
    private Button editAircraftButton;

    @FXML
    private Button delAircraftButton;

    @FXML
    private Button infoAircraftButton;

    @FXML
    private TableView<Aircraft> aircraftsTable;

    @FXML
    private TableColumn<Aircraft, String> aircraftIdNumCol;

    @FXML
    private TableColumn<Aircraft, String> aircraftNameCol;

    @FXML
    private TableColumn<Aircraft, String> aircraftBrandCol;

    @FXML
    private TableColumn<Aircraft, String> aircraftModelCol;

    @FXML
    private TableColumn<Aircraft, Integer> aircraftNumEcoCol;

    @FXML
    private TableColumn<Aircraft, Integer> aircraftNumBusinessCol;

    @FXML
    private Button editCMButton;

    @FXML
    private Button delCMButton;

    @FXML
    private Button infoCMButton;

    @FXML
    private TableView<Crewmember> crewMembersTable;

    @FXML
    private TableColumn<Crewmember, String> CMidCol;

    @FXML
    private TableColumn<Crewmember, String> CMfnameCol;

    @FXML
    private TableColumn<Crewmember, String> CMlnameCol;

    @FXML
    private TableColumn<Crewmember, String> CMpositionCol;

    @FXML
    private Button editPassengerButton;

    @FXML
    private Button delPassengerButton;

    @FXML
    private Button infoPassengerButton;

    @FXML
    private TableView<Passenger> passengersTable;

    @FXML
    private TableColumn<Passenger, String> passengerIdCol;

    @FXML
    private TableColumn<Passenger, String> passengerFnameCol;

    @FXML
    private TableColumn<Passenger, String> passengerLnameCol;

    @FXML
    private Button editTicketButton;

    @FXML
    private Button delTicketButton;

    @FXML
    private Button infoTicketButton;

    @FXML
    private TableView<Ticket> ticketsTable;

    @FXML
    private TableColumn<Ticket, String> ticketNumCol;

    @FXML
    private TableColumn<Ticket, String> ticketPassengerIdCol;

    @FXML
    private TableColumn<Ticket, String> ticketFlightIdCol;

    @FXML
    private TableColumn<Ticket, Integer> flightSeatNumCol;

    @FXML
    private TableColumn<Ticket, String> flightSeatClassCol;

    private void loadFlights(){
        MainWindow.loadFlightsFromDatabase();
        ObservableList<Flight> flights = FXCollections.observableArrayList(MainWindow.getFlights());
        flightsTable.setItems(flights);
        flightNumCol.setCellValueFactory(new PropertyValueFactory<>("flightID"));
        flightOriginCol.setCellValueFactory(new PropertyValueFactory<>("originAirport"));
        flightDestinationCol.setCellValueFactory(new PropertyValueFactory<>("destinationAirport"));
        flightDepartureCol.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        flightArrivalCol.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        flightAircraftCol.setCellValueFactory(new PropertyValueFactory<>("aircraft"));
    }
    private void loadAirports(){
        MainWindow.loadAirportsFromDatabase();
        ObservableList<Airport> airports = FXCollections.observableArrayList(MainWindow.getAirports());
        airportsTable.setItems(airports);
        airportNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        airportIataCol.setCellValueFactory(new PropertyValueFactory<>("IATACode"));
        airportIcaoCol.setCellValueFactory(new PropertyValueFactory<>("ICAOCode"));
        airportCityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        airportCountryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        airportAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
    }
    private void loadAircrafts(){
        MainWindow.loadAircraftsFromDatabase();
        ObservableList<Aircraft> aircrafts = FXCollections.observableArrayList(MainWindow.getAircrafts());
        aircraftsTable.setItems(aircrafts);
        aircraftIdNumCol.setCellValueFactory(new PropertyValueFactory<>("aircraftId"));
        aircraftNameCol.setCellValueFactory(new PropertyValueFactory<>("aircraftName"));
        aircraftBrandCol.setCellValueFactory(new PropertyValueFactory<>("aircraftBrand"));
        aircraftModelCol.setCellValueFactory(new PropertyValueFactory<>("aircraftModel"));
        aircraftNumEcoCol.setCellValueFactory(new PropertyValueFactory<>("seatsAvailableEco"));
        aircraftNumBusinessCol.setCellValueFactory(new PropertyValueFactory<>("seatsAvailableBus"));
    }
    private void loadCrewmembers(){
        MainWindow.loadCrewmembersFromDatabase();
        ObservableList<Crewmember> crewembers = FXCollections.observableArrayList(MainWindow.getCrewmembers());
        crewMembersTable.setItems(crewembers);
        CMidCol.setCellValueFactory(new PropertyValueFactory<>("personId"));
        CMfnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        CMlnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        CMpositionCol.setCellValueFactory(new PropertyValueFactory<>("role"));
    }
    private void loadPassengers(){
        MainWindow.loadPassengersFromDatabase();
        ObservableList<Passenger> passengers = FXCollections.observableArrayList(MainWindow.getPassengers());
        passengersTable.setItems(passengers);
        passengerIdCol.setCellValueFactory(new PropertyValueFactory<>("personId"));
        passengerFnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        passengerLnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    }
    private void loadTickets(){
        MainWindow.loadTicketsFromDatabase();
        ObservableList<Ticket> tickets = FXCollections.observableArrayList(MainWindow.getTickets());
        ticketsTable.setItems(tickets);
        ticketNumCol.setCellValueFactory(new PropertyValueFactory<>("ticketID"));
        ticketPassengerIdCol.setCellValueFactory(new PropertyValueFactory<>("passenger"));
        ticketFlightIdCol.setCellValueFactory(new PropertyValueFactory<>("flight"));
        flightSeatNumCol.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        flightSeatClassCol.setCellValueFactory(new PropertyValueFactory<>("seatClass"));
    }
    private void loadData(){
        loadAirports();
        loadAircrafts();
        loadFlights();
        loadCrewmembers();
        loadPassengers();
        loadTickets();
    }

    public void initialize() {
        while (MainWindow.getDatabase() == null) {
            Dialog<ButtonType> dialog = new Dialog<>();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/CredentialsDialog.fxml"));
            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:src/main/resources/aviation_logo-22.jpg"));
            try{
                DialogPane credentialsDialogPane = fxmlLoader.load();
                CredentialsDialogController credentialsController = fxmlLoader.getController();
                dialog.setDialogPane(credentialsDialogPane);
                dialog.setTitle("Onibmag Airlines");
                Optional<ButtonType> clickedButton = dialog.showAndWait();
                if (clickedButton.isPresent() && clickedButton.get() == ButtonType.OK) {
                    Database db = new Database();
                    db.openConnection(credentialsController.getLoginTextFieldValue(),
                            credentialsController.getPasswordTextFieldValue());
                    if (db.isConnected()) {
                        MainWindow.setDatabase(db);
                        showInfoDialog("Successfully connected to database.", "");
                    } else {
                        showInfoDialog("Database connection error.", "Cannot connect to database. Check credentials and try again.");
                    }
                }
                else {
                    System.exit(0);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MainWindow.loadPositionsFromDatabase(); // must be loaded before Crewmembers
        loadData();

        editFlightButton.disableProperty().bind(Bindings.isNull(flightsTable.getSelectionModel().selectedItemProperty()));
        delFlightButton.disableProperty().bind(Bindings.isNull(flightsTable.getSelectionModel().selectedItemProperty()));
        infoFlightButton.disableProperty().bind(Bindings.isNull(flightsTable.getSelectionModel().selectedItemProperty()));

        editAirportButton.disableProperty().bind(Bindings.isNull(airportsTable.getSelectionModel().selectedItemProperty()));
        delAirportButton.disableProperty().bind(Bindings.isNull(airportsTable.getSelectionModel().selectedItemProperty()));
        infoAirportButton.disableProperty().bind(Bindings.isNull(airportsTable.getSelectionModel().selectedItemProperty()));

        editAircraftButton.disableProperty().bind(Bindings.isNull(aircraftsTable.getSelectionModel().selectedItemProperty()));
        delAircraftButton.disableProperty().bind(Bindings.isNull(aircraftsTable.getSelectionModel().selectedItemProperty()));
        infoAircraftButton.disableProperty().bind(Bindings.isNull(aircraftsTable.getSelectionModel().selectedItemProperty()));

        editCMButton.disableProperty().bind(Bindings.isNull(crewMembersTable.getSelectionModel().selectedItemProperty()));
        delCMButton.disableProperty().bind(Bindings.isNull(crewMembersTable.getSelectionModel().selectedItemProperty()));
        infoCMButton.disableProperty().bind(Bindings.isNull(crewMembersTable.getSelectionModel().selectedItemProperty()));

        editPassengerButton.disableProperty().bind(Bindings.isNull(passengersTable.getSelectionModel().selectedItemProperty()));
        delPassengerButton.disableProperty().bind(Bindings.isNull(passengersTable.getSelectionModel().selectedItemProperty()));
        infoPassengerButton.disableProperty().bind(Bindings.isNull(passengersTable.getSelectionModel().selectedItemProperty()));

        editTicketButton.disableProperty().bind(Bindings.isNull(ticketsTable.getSelectionModel().selectedItemProperty()));
        delTicketButton.disableProperty().bind(Bindings.isNull(ticketsTable.getSelectionModel().selectedItemProperty()));
        infoTicketButton.disableProperty().bind(Bindings.isNull(ticketsTable.getSelectionModel().selectedItemProperty()));
    }

    @FXML
    void handleExit() {
        MainWindow.getDatabase().closeConnection();
        System.exit(0);
    }

    @FXML
    void handleReload() {
        loadData();
        showInfoDialog("Reload", "Data successfully reloaded.");
    }

    @FXML
    void handleAbout() throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://gitlab-stud.elka.pw.edu.pl/mwasilew/pap21z-zxx"));
        }
    }

    @FXML
    void handleFlightAdd(MouseEvent event) {
        handleFlightEdit(event);
    }

    @FXML
    void handleAirportAdd(MouseEvent event) {
        handleAirportEdit(event);
    }

    @FXML
    void handleAircraftAdd(MouseEvent event) {
        handleAircraftEdit(event);
    }

    @FXML
    void handleCMAdd(MouseEvent event) {
        handleCMEdit(event);
    }

    @FXML
    void handlePassengerAdd(MouseEvent event) {
        handlePassengerEdit(event);
    }

    @FXML
    void handleTicketAdd(MouseEvent event) {
        handleTicketEdit(event);
    }

    @FXML
    void handleFlightEdit(MouseEvent event) {
        Flight flight = null;
        String dialogTitle = "Add flight";
        DialogMode mode = DialogMode.ADD;
        Dialog<ButtonType> flightDialog = new Dialog<>();
        FXMLLoader fxmlLoader = new FXMLLoader();

        Stage stage = (Stage) flightDialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/aviation_logo-22.jpg"));

        if (event.getSource().equals(editFlightButton)) {
            mode = DialogMode.EDIT;
            dialogTitle = "Edit flight data";
            flight = flightsTable.getSelectionModel().getSelectedItem();
        }
        try {
            fxmlLoader.setLocation(getClass().getResource("/FlightDialog.fxml"));
            DialogPane flightDialogPane = fxmlLoader.load();
            FlightDialogController flightController = fxmlLoader.getController();
            flightController.setFields(flight);

            flightDialog.setDialogPane(flightDialogPane);
            flightDialog.setTitle(dialogTitle);
            Optional<ButtonType> clickedButton = flightDialog.showAndWait();
            if (clickedButton.isPresent() && clickedButton.get() == ButtonType.OK) {
                String flightNum = flightController.getFlightNumTextFieldValue();
                ArrayList<String> crewIds = flightController.getSelectedCrewIds();
                if ((crewIds.size() > 0) && (flightNum != null) && (flightController.getOrigin() != null) && (flightController.getDestination() != null) &&
                        (flightController.getDepartureTime() != null) && (flightController.getArrivalTime() != null)) {
                    Timestamp departure = Timestamp.valueOf(flightController.getDepartureTime());
                    Timestamp arrival = Timestamp.valueOf(flightController.getArrivalTime());
                    ArrayList<Object> values = new ArrayList<>();
                    values.add(flightNum);
                    values.add(flightController.getOrigin());
                    values.add(flightController.getDestination());
                    values.add(departure);
                    values.add(arrival);
                    values.add(flightController.getAircraftId());

                    if (mode == DialogMode.ADD) {
                        try {
                            flight = Flight.createOneObjectFromList(values);

                            boolean isValid = true;
                            for (var row : MainWindow.getFlights()) {
                                if (row.getFlightID().equals(flightNum)) {
                                    showInfoDialog("Operation error.", "Cannot add another flight with the same number!");
                                    isValid = false;
                                }
                            }
                            if (isValid) {
                                MainWindow.getDatabase().insert(Flight.getDatabaseTableName(), Flight.getDatabaseFields(),
                                        values.toArray());
                                String query = "INSERT ALL";
                                for (String cmId : crewIds) {
                                    query += "  INTO FLIGHTS_CREW (FLIGHT_ID, CREWMEMBER_ID) VALUES ('" + flightNum + "', '" + cmId + "')\n";
                                }
                                MainWindow.getDatabase().executeInsert(query.substring(0, query.length() - 1) + "SELECT 1 FROM DUAL");
                                showInfoDialog("Operation successful!", "Flight added to database.");
                            }
                        } catch (IllegalArgumentException e) {
                            showInfoDialog("Operation error.", e.getMessage());
                        }
                    } else if (mode == DialogMode.EDIT) {
                        try {
                            flight = Flight.createOneObjectFromList(values);
                            String[] fields = {"ORIGIN_AIRPORT", "DESTINATION_AIRPORT", "DEPARTURE_TIME", "ARRIVAL_TIME", "AIRCRAFT_ID"};
                            Object[] fields_values = {flightController.getOrigin(), flightController.getDestination(),
                                    departure, arrival, flightController.getAircraftId()};
                            String condition = "FLIGHT_ID='" + flightNum + "'";
                            MainWindow.getDatabase().update(Flight.getDatabaseTableName(), fields, fields_values, condition);
                            MainWindow.getDatabase().delete("FLIGHTS_CREW", "FLIGHT_ID='" + flightNum + "'");
                            String query = "INSERT ALL";
                            for (String cmId : crewIds) {
                                query += "  INTO FLIGHTS_CREW (FLIGHT_ID, CREWMEMBER_ID) VALUES ('" + flightNum + "', '" + cmId + "')\n";
                            }
                            MainWindow.getDatabase().executeInsert(query.substring(0, query.length() - 1) + "SELECT 1 FROM DUAL");

                            showInfoDialog("Operation successful!", "Flight data edited.");
                        } catch (IllegalArgumentException e) {
                            showInfoDialog("Operation error.", e.getMessage());
                        }
                    }
                    loadFlights();
                }
                else {
                    /* at least some of available fields have not been properly completed */
                    showInfoDialog("Operation error.", "All available fields have to be completed");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleAirportEdit(MouseEvent event) {
        Airport airport = null;
        String dialogTitle = "Add airport";
        DialogMode mode = DialogMode.ADD;
        Dialog<ButtonType> dialog = new Dialog<>();
        FXMLLoader fxmlLoader = new FXMLLoader();

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/aviation_logo-22.jpg"));

        if (event.getSource().equals(editAirportButton)) {
            mode = DialogMode.EDIT;
            dialogTitle = "Edit airport data";
            airport = airportsTable.getSelectionModel().getSelectedItem();
        }
        try {
            fxmlLoader.setLocation(getClass().getResource("/AirportDialog.fxml"));
            DialogPane airportDialogPane = fxmlLoader.load();
            AirportDialogController airportController = fxmlLoader.getController();
            airportController.setFields(airport);

            dialog.setDialogPane(airportDialogPane);
            dialog.setTitle(dialogTitle);
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.isPresent() && clickedButton.get() == ButtonType.OK) {
                String ICAOcode = airportController.getICAOcodeTextField().toUpperCase(Locale.ROOT);
                String IATAcode = airportController.getIATAcodeTextField().toUpperCase(Locale.ROOT);
                ArrayList<Object> values = new ArrayList<>();
                values.add(IATAcode);
                values.add(ICAOcode);
                values.add(airportController.getNameTextFieldValue());
                values.add(airportController.getCityTextField());
                values.add(airportController.getCountryTextField());
                values.add(airportController.getAddressTextField());
                if (mode == DialogMode.ADD) {
                    try {
                        airport = Airport.createOneObjectFromList(values);

                        // check whether airport with given IATA and ICAO codes already exists in the database or not
                        // if not it can be proceeded and added to the database
                        boolean isValid = true;
                        for (var row : MainWindow.getAirports()) {
                            if ((row.getICAOCode().equals(ICAOcode)) || (row.getIATACode().equals(IATAcode))) {
                                showInfoDialog("Operation error.", "Cannot add another airport with the same ICAO or IATA codes!");
                                isValid = false;
                            }
                        }

                        if (isValid) {
                            MainWindow.getDatabase().insert(Airport.getDatabaseTableName(), Airport.getDatabaseFields(),
                                    values.toArray());
                            showInfoDialog("Operation successful!", "Airport added to database.");
                        }
                    } catch (IllegalArgumentException e) {
                        showInfoDialog("Operation error.", e.getMessage());
                    }
                }
                else if (mode == DialogMode.EDIT) {
                    try {
                        airport = Airport.createOneObjectFromList(values);
                        String[] fields = {"NAME", "CITY", "COUNTRY", "ADDRESS"};
                        String[] fields_values = {airportController.getNameTextFieldValue(), airportController.getCityTextField(),
                                airportController.getCountryTextField(), airportController.getAddressTextField()};
                        String condition = "IATA_CODE='" + IATAcode + "' AND ICAO_CODE='" + ICAOcode + "'";
                        MainWindow.getDatabase().update(Airport.getDatabaseTableName(), fields, fields_values, condition);
                        showInfoDialog("Operation successful!", "Airport data edited.");
                    } catch (IllegalArgumentException e) {
                        showInfoDialog("Operation error.", e.getMessage());
                    }
                }
                loadAirports();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleAircraftEdit(MouseEvent event) {
        Aircraft aircraft = null;
        String dialogTitle = "Add aircraft";
        DialogMode mode = DialogMode.ADD;
        Dialog<ButtonType> dialog = new Dialog<>();
        FXMLLoader fxmlLoader = new FXMLLoader();

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/aviation_logo-22.jpg"));

        if (event.getSource().equals(editAircraftButton)) {
            mode = DialogMode.EDIT;
            dialogTitle = "Edit airport data";
            aircraft = aircraftsTable.getSelectionModel().getSelectedItem();
        }
        try {
            fxmlLoader.setLocation(getClass().getResource("/AircraftDialog.fxml"));
            DialogPane aircraftDialogPane = fxmlLoader.load();
            AircraftDialogController aircraftController = fxmlLoader.getController();
            aircraftController.setFields(aircraft);

            dialog.setDialogPane(aircraftDialogPane);
            dialog.setTitle(dialogTitle);
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.isPresent() && clickedButton.get() == ButtonType.OK) {
                ArrayList<Object> values = new ArrayList<>();
                String idNumber = aircraftController.getIdNumTextFieldValue();
                values.add(idNumber);
                values.add(aircraftController.getNameTextFieldValue());
                values.add(aircraftController.getBrandTextFieldValue());
                values.add(aircraftController.getEcoSeatsNumSpinnerValue());
                values.add(aircraftController.getBusinessSeatsNumSpinnerValue());
                values.add(aircraftController.getModelTextFieldValue());
                if (mode == DialogMode.ADD) {
                    try {
                        aircraft = Aircraft.createOneObjectFromList(values);

                        // check whether aircraft with given idNumber already exists in the database or not
                        // if not it can be proceeded and added to the database
                        boolean isValid = true;
                        for (var row : MainWindow.getAircrafts()) {
                            if (row.getAircraftId().equals(idNumber)) {
                                showInfoDialog("Operation error.", "Cannot add another aircraft with id: " + idNumber);
                                isValid = false;
                            }
                        }

                        if (isValid) {
                            MainWindow.getDatabase().insert(Aircraft.getDatabaseTableName(), Aircraft.getDatabaseFields(),
                                    values.toArray());
                            showInfoDialog("Operation successful!", "Aircraft added to database.");
                        }
                    } catch (IllegalArgumentException e) {
                        showInfoDialog("Operation error.", e.getMessage());
                    }
                }
                else if (mode == DialogMode.EDIT) {
                    try {
                        aircraft = Aircraft.createOneObjectFromList(values);
                        String[] fields = {"NAME", "BRAND", "MAX_ECO_SEATS", "MAX_BUSINESS_SEATS", "MODEL"};
                        String[] fields_values = {aircraftController.getNameTextFieldValue(),
                                                aircraftController.getBrandTextFieldValue(),
                                                aircraftController.getEcoSeatsNumSpinnerValue().toString(),
                                                aircraftController.getBusinessSeatsNumSpinnerValue().toString(),
                                                aircraftController.getModelTextFieldValue()};
                        String condition = "AIRCRAFT_ID='" + idNumber + "'";
                        MainWindow.getDatabase().update(Aircraft.getDatabaseTableName(), fields, fields_values, condition);
                        showInfoDialog("Operation successful!", "Aircraft data edited.");
                    } catch (IllegalArgumentException e) {
                        showInfoDialog("Operation error.", e.getMessage());
                    }
                }
                loadAircrafts();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleCMEdit(MouseEvent event) {
        Crewmember crewmember = null;
        String dialogTitle = "Add crew member";
        DialogMode mode = DialogMode.ADD;
        Dialog<ButtonType> dialog = new Dialog<>();
        FXMLLoader fxmlLoader = new FXMLLoader();

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/aviation_logo-22.jpg"));

        if (event.getSource().equals(editCMButton)) {
            mode = DialogMode.EDIT;
            dialogTitle = "Edit crew member data";
            crewmember = crewMembersTable.getSelectionModel().getSelectedItem();
        }
        try {
            fxmlLoader.setLocation(getClass().getResource("/CrewmemberDialog.fxml"));
            DialogPane CMDialogPane = fxmlLoader.load();
            CrewmemberDialogController CMController = fxmlLoader.getController();
            CMController.setFields(crewmember);

            dialog.setDialogPane(CMDialogPane);
            dialog.setTitle(dialogTitle);
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.isPresent() && clickedButton.get() == ButtonType.OK) {
                if(CMController.getPositionId() == null) {
                    showInfoDialog("Operation error.", "All available fields have to be completed");
                } else {
                    String idNumber = CMController.getPersonIdTextField();
                    ArrayList<Object> values = new ArrayList<>();
                    values.add(idNumber);
                    values.add(CMController.getFirstNameTextField());
                    values.add(CMController.getLastNameTextField());
                    values.add(CMController.getPositionId());
                    if (mode == DialogMode.ADD) {
                        try {
                            crewmember = Crewmember.createOneObjectFromList(values);

                            // check whether crewmember with given idNumber already exists in the database or not
                            // if not it can be proceeded and added to the database
                            boolean isValid = true;
                            for (var row : MainWindow.getCrewmembers()) {
                                if (row.getPersonId().equals(idNumber)) {
                                    showInfoDialog("Operation error.", "Cannot add another crew member with id: " + idNumber);
                                    isValid = false;
                                }
                            }

                            if (isValid) {
                                MainWindow.getDatabase().insert(Crewmember.getDatabaseTableName(), Crewmember.getDatabaseFields(),
                                        values.toArray());
                                showInfoDialog("Operation successful!", "Crew member added to database.");
                            }
                        } catch (IllegalArgumentException e) {
                            showInfoDialog("Operation error.", e.getMessage());
                        }
                    }
                    else if (mode == DialogMode.EDIT) {
                        try {
                            crewmember = Crewmember.createOneObjectFromList(values);
                            String[] fields = {"FIRST_NAME", "LAST_NAME", "POSITION_ID"};
                            String[] fields_values = {CMController.getFirstNameTextField(),
                                    CMController.getLastNameTextField(),
                                    CMController.getPositionId().toString()};
                            String condition = "PERSON_ID='" + idNumber + "'";
                            MainWindow.getDatabase().update(Crewmember.getDatabaseTableName(), fields, fields_values, condition);
                            showInfoDialog("Operation successful!", "Crew member data edited.");
                        } catch (IllegalArgumentException e) {
                            showInfoDialog("Operation error.", e.getMessage());
                        }
                    }
                    loadCrewmembers();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handlePassengerEdit(MouseEvent event) {
        Passenger passenger = null;
        String dialogTitle = "Add passenger";
        DialogMode mode = DialogMode.ADD;
        Dialog<ButtonType> dialog = new Dialog<>();
        FXMLLoader fxmlLoader = new FXMLLoader();

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/aviation_logo-22.jpg"));

        if (event.getSource().equals(editPassengerButton)) {
            mode = DialogMode.EDIT;
            dialogTitle = "Edit passenger data";
            passenger = passengersTable.getSelectionModel().getSelectedItem();
        }
        try {
            fxmlLoader.setLocation(getClass().getResource("/PassengerDialog.fxml"));
            DialogPane PassengerDialogPane = fxmlLoader.load();
            PassengerDialogController PassengerController = fxmlLoader.getController();
            PassengerController.setFields(passenger);

            dialog.setDialogPane(PassengerDialogPane);
            dialog.setTitle(dialogTitle);
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.isPresent() && clickedButton.get() == ButtonType.OK) {
                String idNumber = PassengerController.getPersonIdTextField();
                ArrayList<Object> values = new ArrayList<>();
                values.add(idNumber);
                values.add(PassengerController.getFirstNameTextField());
                values.add(PassengerController.getLastNameTextField());
                if (mode == DialogMode.ADD) {
                    try {
                        passenger = Passenger.createOneObjectFromList(values);

                        boolean isValid = true;
                        for (var row : MainWindow.getPassengers()) {
                            if (row.getPersonId().equals(idNumber)) {
                                showInfoDialog("Operation error.", "Cannot add another passenger with id: " + idNumber);
                                isValid = false;
                            }
                        }

                        if (isValid) {
                            MainWindow.getDatabase().insert(Passenger.getDatabaseTableName(), Passenger.getDatabaseFields(),
                                    values.toArray());
                            showInfoDialog("Operation successful!", "Passenger added to database.");
                        }
                    } catch (IllegalArgumentException e) {
                        showInfoDialog("Operation error.", e.getMessage());
                    }
                }
                else if (mode == DialogMode.EDIT) {
                    try {
                        passenger = Passenger.createOneObjectFromList(values);
                        String[] fields = {"FIRST_NAME", "LAST_NAME"};
                        String[] fields_values = {PassengerController.getFirstNameTextField(),
                                PassengerController.getLastNameTextField()};
                        String condition = "PERSON_ID='" + idNumber + "'";
                        MainWindow.getDatabase().update(Passenger.getDatabaseTableName(), fields, fields_values, condition);
                        showInfoDialog("Operation successful!", "Crew member data edited.");
                    } catch (IllegalArgumentException e) {
                        showInfoDialog("Operation error.", e.getMessage());
                    }
                }
                loadPassengers();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleTicketEdit(MouseEvent event) {
        Ticket ticket = null;
        String dialogTitle = "Add ticket";
        DialogMode mode = DialogMode.ADD;
        Dialog<ButtonType> ticketDialog = new Dialog<>();
        FXMLLoader fxmlLoader = new FXMLLoader();

        Stage stage = (Stage) ticketDialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/aviation_logo-22.jpg"));

        if (event.getSource().equals(editTicketButton)) {
            mode = DialogMode.EDIT;
            dialogTitle = "Edit ticket data";
            ticket = ticketsTable.getSelectionModel().getSelectedItem();
        }
        try {
            fxmlLoader.setLocation(getClass().getResource("/TicketDialog.fxml"));
            DialogPane ticketDialogPane = fxmlLoader.load();
            TicketDialogController ticketController = fxmlLoader.getController();
            ticketController.setFields(ticket);

            ticketDialog.setDialogPane(ticketDialogPane);
            ticketDialog.setTitle(dialogTitle);
            Optional<ButtonType> clickedButton = ticketDialog.showAndWait();
            if (clickedButton.isPresent() && clickedButton.get() == ButtonType.OK) {
                String ticketId = ticketController.getTicketIdTextFieldValue();
                String seatClass = ticketController.getSeatClass();
                String seatNumber = ticketController.getSeatNumber();
                String flightId = ticketController.getFlight();

                if ((seatClass == null) || (seatNumber == null) || (flightId == null) || (ticketController.getPassenger() == null)) {
                    showInfoDialog("Operation error.", "All available fields have to be completed");
                }
                else {
                    ArrayList<Object> values = new ArrayList<>();
                    values.add(ticketId);
                    values.add(ticketController.getPassenger());
                    values.add(flightId);
                    values.add(seatNumber);
                    values.add(seatClass);
                    if (mode == DialogMode.ADD) {
                        try{
                            ticket = Ticket.createOneObjectFromList(values);

                            boolean isValid = true;
                            for (var row : MainWindow.getTickets()) {
                                if (row.getFlightID().equals(ticketId)) {
                                    showInfoDialog("Operation error.", "Cannot add another ticket with the same number!");
                                    isValid = false;
                                }
                            }
                            if (isValid) {
                                MainWindow.getDatabase().insert(Ticket.getDatabaseTableName(), Ticket.getDatabaseFields(),
                                        values.toArray());
                                showInfoDialog("Operation successful!", "Ticket added to database.");
                            }
                        } catch (IllegalArgumentException e) {
                            showInfoDialog("Operation error.", e.getMessage());
                        }
                    }
                    else if (mode == DialogMode.EDIT) {
                        try {
                            ticket = Ticket.createOneObjectFromList(values);
                            String[] fields = {"PASSENGER_ID", "FLIGHT_ID", "SEAT_NUMBER", "SEAT_CLASS"};
                            String[] fields_values = {ticketController.getPassenger(), flightId, seatNumber, seatClass};
                            String condition = "TICKET_ID='" + ticketId + "'";
                            MainWindow.getDatabase().update(Ticket.getDatabaseTableName(), fields, fields_values, condition);

                            showInfoDialog("Operation successful!", "Ticket data edited.");
                        } catch (IllegalArgumentException e) {
                            showInfoDialog("Operation error.", e.getMessage());
                        }
                    }
                    loadTickets();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleDelete(MouseEvent event) {
        Object eventSource = event.getSource();
        String header = "";
        String content = "";

        if (eventSource.equals(delFlightButton)){
            header = "Flight delete confirmation";
            content = "Are you sure you would like to remove this flight?";
        }
        else if (eventSource.equals(delAirportButton)){
            header = "Airport delete confirmation";
            content = "Are you sure you would like to remove this airport?";
        }
        else if (eventSource.equals(delAircraftButton)){
            header = "Aircraft delete confirmation";
            content = "Are you sure you would like to remove this aircraft?";
        }
        else if (eventSource.equals(delCMButton)){
            header = "Crew member delete confirmation";
            content = "Are you sure you would like to remove this crew member?";
        }
        else if (eventSource.equals(delPassengerButton)){
            header = "Passenger delete confirmation";
            content = "Are you sure you would like to remove this passenger?";
        }
        else if (eventSource.equals(delTicketButton)){
            header = "Ticket delete confirmation";
            content = "Are you sure you would like to remove this ticket?";
        }
        Optional<ButtonType> isConfirmed = showConfirmationDialog(header, content);
        if (isConfirmed.get() == ButtonType.OK) {
            if (eventSource.equals(delFlightButton)) {
                Flight flight = flightsTable.getSelectionModel().getSelectedItem();
                String condition = "flight_id = '" + flight.getFlightID() + "'";
                MainWindow.getDatabase().delete(Flight.getDatabaseTableName(), condition);
            }
            else if (eventSource.equals(delAirportButton)) {
                Airport airport = airportsTable.getSelectionModel().getSelectedItem();
                String condition = "icao_code = '" + airport.getICAOCode() + "'";
                MainWindow.getDatabase().delete(Airport.getDatabaseTableName(), condition);
            }
            else if (eventSource.equals(delAircraftButton)) {
                Aircraft aircraft = aircraftsTable.getSelectionModel().getSelectedItem();
                String condition = "aircraft_id = '" + aircraft.getAircraftId() + "'";
                MainWindow.getDatabase().delete(Aircraft.getDatabaseTableName(), condition);
            }
            else if (eventSource.equals(delCMButton)) {
                Crewmember crewmember = crewMembersTable.getSelectionModel().getSelectedItem();
                ArrayList<Flight> flights = crewmember.getFlights();
                if (flights.size() != 0) {
                    String flightNums = "";
                    for (Flight flight : flights){
                        flightNums += flight.getFlightID() + ", ";
                    }
                    showInfoDialog("Operation error.", "Crew member is assigned to flights with numbers: " + flightNums + "change flights data and try again.");
                } else {
                    String condition = "person_id = '" + crewmember.getPersonId() + "'";
                    MainWindow.getDatabase().delete(Crewmember.getDatabaseTableName(), condition);
                }
            }
            else if (eventSource.equals(delPassengerButton)) {
                Passenger passenger = passengersTable.getSelectionModel().getSelectedItem();
                String condition = "person_id = '" + passenger.getPersonId() + "'";
                MainWindow.getDatabase().delete(Passenger.getDatabaseTableName(), condition);
            }
            else if (eventSource.equals(delTicketButton)) {
                Ticket ticket = ticketsTable.getSelectionModel().getSelectedItem();
                String condition = "ticket_id = '" + ticket.getTicketID() + "'";
                MainWindow.getDatabase().delete(Ticket.getDatabaseTableName(), condition);
            }
            loadData();
        }
    }

    @FXML
    void handleInfo(MouseEvent event) {
        Object eventSource = event.getSource();
        Dialog<Boolean> dialog = new Dialog<>();
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE));
        WebView web = new WebView();

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/aviation_logo-22.jpg"));

        if (eventSource.equals(infoFlightButton)) {
            Flight flight = flightsTable.getSelectionModel().getSelectedItem();
            dialog.setTitle(flight.getFlightID());
            web.getEngine().loadContent(DetailsHTMLGen.generateFlightHTML(flight));
        }
        else if (eventSource.equals(infoAirportButton)) {
            Airport airport = airportsTable.getSelectionModel().getSelectedItem();
            dialog.setTitle(airport.getName());
            web.getEngine().loadContent(DetailsHTMLGen.generateAirportHTML(airport));
        }
        else if (eventSource.equals(infoAircraftButton)) {
            Aircraft aircraft = aircraftsTable.getSelectionModel().getSelectedItem();
            dialog.setTitle(aircraft.getAircraftId());
            web.getEngine().loadContent(DetailsHTMLGen.generateAircraftHTML(aircraft));
        }
        else if (eventSource.equals(infoCMButton)) {
            Crewmember crewmember = crewMembersTable.getSelectionModel().getSelectedItem();
            dialog.setTitle(crewmember.getPersonId());
            web.getEngine().loadContent(DetailsHTMLGen.generateCrewmemberHTML(crewmember));
        }
        else if (eventSource.equals(infoPassengerButton)) {
            Passenger passenger = passengersTable.getSelectionModel().getSelectedItem();
            dialog.setTitle(passenger.getPersonId());
            web.getEngine().loadContent(DetailsHTMLGen.generatePassengerHTML(passenger));
        }
        else if (eventSource.equals(infoTicketButton)) {
            Ticket ticket = ticketsTable.getSelectionModel().getSelectedItem();
            dialog.setTitle(ticket.getTicketID());
            web.getEngine().loadContent(DetailsHTMLGen.generateTicketHTML(ticket));
        }
        dialog.getDialogPane().setContent(web);
        dialog.showAndWait();
    }

    private Optional<ButtonType> showConfirmationDialog(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("OnibmagAirlines");
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert.showAndWait();
    }

    private void showInfoDialog(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("OnibmagAirlines");
        alert.setHeaderText(header);
        if (!content.equals("")) {
            alert.setContentText(content);
        }
        alert.showAndWait();
    }
}
