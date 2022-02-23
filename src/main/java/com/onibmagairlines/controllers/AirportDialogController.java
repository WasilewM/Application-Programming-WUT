package com.onibmagairlines.controllers;

import com.onibmagairlines.classes.Airport;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AirportDialogController {
    private Airport airport;
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField IATAcodeTextField;

    @FXML
    private TextField ICAOcodeTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField addressTextField;

    void setFields(Airport selectedAirport) {
        if (selectedAirport != null) {
            nameTextField.textProperty().setValue(selectedAirport.getName());
            IATAcodeTextField.textProperty().setValue(selectedAirport.getIATACode());
            ICAOcodeTextField.textProperty().setValue(selectedAirport.getICAOCode());
            cityTextField.textProperty().setValue(selectedAirport.getCity());
            countryTextField.textProperty().setValue(selectedAirport.getCountry());
            addressTextField.textProperty().setValue(selectedAirport.getAddress());
            IATAcodeTextField.setDisable(true);
            ICAOcodeTextField.setDisable(true);
        }
    }
    String getNameTextFieldValue() {
        return nameTextField.textProperty().getValue();
    }
    String getIATAcodeTextField() {
        return IATAcodeTextField.textProperty().getValue();
    }
    String getICAOcodeTextField() {
        return ICAOcodeTextField.textProperty().getValue();
    }
    String getCityTextField() {
        return cityTextField.textProperty().getValue();
    }
    String getCountryTextField() {
        return countryTextField.textProperty().getValue();
    }
    String getAddressTextField() {
        return addressTextField.textProperty().getValue();
    }
}
