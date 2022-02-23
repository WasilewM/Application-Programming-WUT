package com.onibmagairlines.controllers;

import com.onibmagairlines.classes.Aircraft;
import com.onibmagairlines.classes.Airport;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class AircraftDialogController {

    @FXML
    private TextField idNumTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField brandTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private Spinner<Integer> ecoSeatsNumSpinner;

    @FXML
    private Spinner<Integer> businessSeatsNumSpinner;

    private void setSpinnerNumberOnly(Spinner<Integer> spinner) {
        spinner.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                spinner.getEditor().setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    void setFields(Aircraft selectedAircraft) {
        setSpinnerNumberOnly(ecoSeatsNumSpinner);
        setSpinnerNumberOnly(businessSeatsNumSpinner);

        if (selectedAircraft != null) {
            idNumTextField.textProperty().setValue(selectedAircraft.getAircraftId());
            nameTextField.textProperty().setValue(selectedAircraft.getAircraftName());
            brandTextField.textProperty().setValue(selectedAircraft.getAircraftBrand());
            modelTextField.textProperty().setValue(selectedAircraft.getAircraftModel());
            ecoSeatsNumSpinner.getValueFactory().setValue(selectedAircraft.getSeatsAvailableEco());
            businessSeatsNumSpinner.getValueFactory().setValue(selectedAircraft.getSeatsAvailableBus());
            idNumTextField.setDisable(true);
        }
    }
    String getIdNumTextFieldValue() {
        return idNumTextField.textProperty().getValue();
    }
    String getNameTextFieldValue() {
        return nameTextField.textProperty().getValue();
    }
    String getBrandTextFieldValue() {
        return brandTextField.textProperty().getValue();
    }
    String getModelTextFieldValue() {
        return modelTextField.textProperty().getValue();
    }
    Integer getEcoSeatsNumSpinnerValue() {
        return ecoSeatsNumSpinner.getValue();
    }
    Integer getBusinessSeatsNumSpinnerValue() {
        return businessSeatsNumSpinner.getValue();
    }
}
