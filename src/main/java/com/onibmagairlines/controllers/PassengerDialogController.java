package com.onibmagairlines.controllers;

import com.onibmagairlines.classes.Passenger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PassengerDialogController {
    @FXML
    private TextField personIdTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    void setFields(Passenger selectedCM) {
        if (selectedCM != null) {
            personIdTextField.textProperty().setValue(selectedCM.getPersonId());
            firstNameTextField.textProperty().setValue(selectedCM.getFirstName());
            lastNameTextField.textProperty().setValue(selectedCM.getLastName());
            personIdTextField.setDisable(true);
        }
    }

    public String getPersonIdTextField() {
        return personIdTextField.textProperty().getValue();
    }

    public String getFirstNameTextField() {
        return firstNameTextField.textProperty().getValue();
    }

    public String getLastNameTextField() {
        return lastNameTextField.textProperty().getValue();
    }

}
