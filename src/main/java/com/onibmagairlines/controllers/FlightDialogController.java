package com.onibmagairlines.controllers;

import com.onibmagairlines.classes.Crewmember;
import com.onibmagairlines.classes.Flight;
import com.onibmagairlines.classes.Utils;
import com.onibmagairlines.javafx.MainWindow;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.SearchableComboBox;

import jfxtras.scene.control.LocalDateTimeTextField;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightDialogController {

    @FXML
    private TextField flightNumTextField;

    @FXML
    private SearchableComboBox<String> originChoiceBox;

    @FXML
    private SearchableComboBox<String> destinationChoiceBox;

    @FXML
    private LocalDateTimeTextField departureDatePicker;

    @FXML
    private LocalDateTimeTextField arrivalDatePicker;

    @FXML
    private SearchableComboBox<String> aircraftChoiceBox;

    @FXML
    private SearchableComboBox<String> captainChoiceBox;

    @FXML
    private SearchableComboBox<String> firstOfficerChoiceBox;

    @FXML
    private CheckComboBox<String> stewardsCheckComboBox;

    @FXML
    private CheckComboBox<String> techniciansCheckComboBox;

    private Map<String, String> airports = new HashMap<>();
    private Map<String, String> aircrafts = new HashMap<>();
    private Map<String, String>  captains = new HashMap<>();
    private Map<String, String>  firstOfficers = new HashMap<>();
    private Map<String, String>  stewards = new HashMap<>();
    private Map<String, String>  technicians = new HashMap<>();

    void setFields(Flight selectedFlight) {
        airports = Utils.getAirportsMap(false);
        aircrafts = Utils.getAircraftsMap();
        captains = createCrewmembersMap(getCrewmembersWithGivenRole("captain"));
        firstOfficers = createCrewmembersMap(getCrewmembersWithGivenRole("first officer"));
        stewards = createCrewmembersMap(getCrewmembersWithGivenRole("steward"));
        technicians = createCrewmembersMap(getCrewmembersWithGivenRole("technician"));

        originChoiceBox.getItems().setAll(airports.values());
        destinationChoiceBox.getItems().setAll(airports.values());
        aircraftChoiceBox.getItems().setAll(aircrafts.values());
        captainChoiceBox.getItems().setAll(captains.values());
        firstOfficerChoiceBox.getItems().setAll(firstOfficers.values());
        stewardsCheckComboBox.getItems().setAll(stewards.values());
        techniciansCheckComboBox.getItems().setAll(technicians.values());

        if (selectedFlight != null) {
            flightNumTextField.textProperty().setValue(selectedFlight.getFlightID());
            originChoiceBox.setValue(airports.get(selectedFlight.getOriginAirport()));
            destinationChoiceBox.setValue(airports.get(selectedFlight.getDestinationAirport()));
            departureDatePicker.localDateTimeProperty().setValue(selectedFlight.getDepartureTime().toLocalDateTime());
            arrivalDatePicker.localDateTimeProperty().setValue(selectedFlight.getArrivalTime().toLocalDateTime());
            aircraftChoiceBox.setValue(aircrafts.get(selectedFlight.getAircraftId()));
            captainChoiceBox.setValue(captains.get(selectedFlight.getCaptainID()));
            firstOfficerChoiceBox.setValue(firstOfficers.get(selectedFlight.getFirstOfficerID()));
            for (String cmId : selectedFlight.getStewardsIds()) {
                stewardsCheckComboBox.getCheckModel().check(stewards.get(cmId));
            }
            for (String cmId : selectedFlight.getTechniciansIds()) {
                techniciansCheckComboBox.getCheckModel().check(technicians.get(cmId));
            }
            flightNumTextField.setDisable(true);
        }
    }

    ArrayList<String> createCrewmemberDescriptionList(ArrayList<Crewmember> crewmembers) {
        ArrayList<String> crewmemberDescriptionList = new ArrayList<>();
        for (var row : crewmembers) {
            crewmemberDescriptionList.add(row.getPersonId() + " - " + row.getLastName() + " " + row.getFirstName());
        }
        return crewmemberDescriptionList;
    }

    ArrayList<Crewmember> getCrewmembersWithGivenRole(String role) {
        return Crewmember.createMultipleObjectsFromList(MainWindow.getDatabase().executeQuery("""
                SELECT C.PERSON_ID, C.FIRST_NAME, C.LAST_NAME, C.POSITION_ID
                FROM CREWMEMBERS C
                JOIN POSITIONS P on C.POSITION_ID = P.POSITION_ID
                WHERE P.NAME = '""" + role + "'"));
    }

    Map<String, String> createCrewmembersMap(ArrayList<Crewmember> crewmembers) {
        Map<String, String> crewmembersMap = new HashMap<>();
        for (var cm : crewmembers) {
            crewmembersMap.put(cm.getPersonId(), cm.getPersonId() + ": " + cm.getLastName() + " - " + cm.getFirstName());
        }
        return crewmembersMap;
    }

    String getFlightNumTextFieldValue() {
        return flightNumTextField.textProperty().getValue();
    }

    ArrayList<String> getSelectedCrewIds() {
        ArrayList<String> selectedIds = new ArrayList<>();
        if((captainChoiceBox.getValue() == null) || (firstOfficerChoiceBox.getValue() == null) ||
                (stewardsCheckComboBox.getCheckModel().getCheckedIndices().size() == 0) ||
                (techniciansCheckComboBox.getCheckModel().getCheckedIndices().size() == 0)) {
            return selectedIds;     /* returning empty list will be interpreted as not choosing some of obligatory fields */
        }

        selectedIds.add(getMapKeyFromValue(captainChoiceBox.getValue(), captains));
        selectedIds.add(getMapKeyFromValue(firstOfficerChoiceBox.getValue(), firstOfficers));

        for (int cm : (stewardsCheckComboBox.getCheckModel().getCheckedIndices())){
            selectedIds.add(getMapKeyFromValue(stewardsCheckComboBox.getCheckModel().getItem(cm), stewards));
        }
        for (int cm : (techniciansCheckComboBox.getCheckModel().getCheckedIndices())){
            selectedIds.add(getMapKeyFromValue(techniciansCheckComboBox.getCheckModel().getItem(cm), technicians));
        }

        return selectedIds;
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

    String getOrigin() {
        return getMapKeyFromValue(originChoiceBox.getValue(), airports);
    }

    String getDestination() {
        return getMapKeyFromValue(destinationChoiceBox.getValue(), airports);
    }

    LocalDateTime getDepartureTime() { return departureDatePicker.getLocalDateTime(); }

    LocalDateTime getArrivalTime() { return arrivalDatePicker.getLocalDateTime(); }

    public String getAircraftId() { return getMapKeyFromValue(aircraftChoiceBox.getValue(), aircrafts); }

}
