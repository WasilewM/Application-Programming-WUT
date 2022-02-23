package com.onibmagairlines.controllers;

import com.onibmagairlines.classes.*;
import com.onibmagairlines.javafx.MainWindow;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import jfxtras.scene.control.LocalDateTimeTextField;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.SearchableComboBox;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TicketDialogController {

    @FXML
    private TextField ticketNumTextField;

    @FXML
    private SearchableComboBox<String> passengerChoiceBox;

    @FXML
    private SearchableComboBox<String> flightChoiceBox;

    @FXML
    private ChoiceBox<String> seatClassChoiceBox;

    @FXML
    private SearchableComboBox<String> seatNumChoiceBox;

    private Map<String, String> passengers = new HashMap<>();
    private Map<String, String> flights = new HashMap<>();
    private final String[] seatClasses = {"ECO", "BUSINESS"};
    private Map<String, String>  seatNumbers = new HashMap<>();

    void setFields(Ticket selectedTicket) {
        passengers = Utils.getPassengersMap();
        flights = Utils.getFlightsMap(false);

        passengerChoiceBox.getItems().setAll(passengers.values());
        flightChoiceBox.getItems().setAll(flights.values());
        seatClassChoiceBox.getItems().setAll(seatClasses);
        seatClassChoiceBox.getSelectionModel().selectFirst();

        seatClassChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (options, oldValue, newValue) -> updateSeatsList(newValue)
        );
        flightChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (options, oldValue, newValue) -> updateSeatsList(seatClassChoiceBox.getValue())
        );

        if (selectedTicket != null) {
            ticketNumTextField.textProperty().setValue(selectedTicket.getTicketID());
            passengerChoiceBox.setValue(passengers.get(selectedTicket.getPassengerID()));
            flightChoiceBox.setValue(flights.get(selectedTicket.getFlightID()));
            seatClassChoiceBox.setValue(selectedTicket.getSeatClass());
            updateSeatsList(selectedTicket.getSeatClass());
            seatNumChoiceBox.setValue(String.valueOf(selectedTicket.getSeatNumber()));

            ticketNumTextField.setDisable(true);
        }
    }
    @FXML
    private void updateSeatsList(String selectedClass) {
        String selectedFlightId = getMapKeyFromValue(flightChoiceBox.getValue(), flights);
        seatNumChoiceBox.setValue(null);
        if (selectedClass.equals("ECO") && selectedFlightId != null) {
            setSeatList(selectedFlightId, "MAX_ECO_SEATS", "OCCUPIED_ECO_SEATS");
        }
        else if (selectedClass.equals("BUSINESS") && selectedFlightId != null) {
            setSeatList(selectedFlightId, "MAX_BUSINESS_SEATS", "OCCUPIED_BUSINESS_SEATS");
        }
    }

    private void setSeatList(String selectedFlightId, String seatsColumn, String tableName) {
        String seatNumQuery = "SELECT A." + seatsColumn + " FROM " + Aircraft.getDatabaseTableName() + " A JOIN ";
        seatNumQuery += Flight.getDatabaseTableName() + " F ON A.AIRCRAFT_ID = F.AIRCRAFT_ID WHERE F.FLIGHT_ID='";
        seatNumQuery += selectedFlightId + "'";
        int numOfSeats = ((BigDecimal) MainWindow.getDatabase().executeQuery(seatNumQuery).get(0).get(0)).intValue();
        ArrayList<String> seatList = new ArrayList<>();
        for (int i = 1; i <= numOfSeats; i++){
            seatList.add(String.valueOf(i));
        }
        String occupiedSeatsQuery = "SELECT SEAT_NUMBER FROM " + tableName + " WHERE FLIGHT_ID='";
        occupiedSeatsQuery += selectedFlightId + "'";
        ArrayList<ArrayList<Object>> occupiedSeats = MainWindow.getDatabase().executeQuery(occupiedSeatsQuery);
        for (var oc : occupiedSeats) {
            seatList.remove(String.valueOf(oc.get(0)));
        }
        seatNumChoiceBox.getItems().setAll(seatList);
    }

    public String getMapKeyFromValue(String value, Map<String, String> map) {
        String key_to_find = null;
        for (String key : map.keySet()){
            if (map.get(key).equals(value)){
                key_to_find = key;
                break;
            }
        }
        return key_to_find;
    }

    public String getTicketIdTextFieldValue() {
        return ticketNumTextField.textProperty().getValue();
    }

    public String getPassenger() {
        return getMapKeyFromValue(passengerChoiceBox.getValue(), passengers);
    }

    public String getFlight() {
        return getMapKeyFromValue(flightChoiceBox.getValue(), flights);
    }

    public String getSeatClass() {
        return seatClassChoiceBox.getValue();
    }

    public String getSeatNumber() {
        return seatNumChoiceBox.getValue();
    }

}
