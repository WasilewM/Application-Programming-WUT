package com.onibmagairlines.controllers;

import com.onibmagairlines.classes.Crewmember;
import com.onibmagairlines.classes.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.control.SearchableComboBox;

import java.util.HashMap;
import java.util.Map;

public class CrewmemberDialogController {
    @FXML
    private TextField personIdTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private SearchableComboBox<String> roleChoiceBox;

    private Map<Integer, String> positions = new HashMap<>();

    void setFields(Crewmember selectedCM) {
        positions = Utils.getPositionsMap();
        roleChoiceBox.getItems().setAll(positions.values());
        if (selectedCM != null) {
            personIdTextField.textProperty().setValue(selectedCM.getPersonId());
            firstNameTextField.textProperty().setValue(selectedCM.getFirstName());
            lastNameTextField.textProperty().setValue(selectedCM.getLastName());
            roleChoiceBox.setValue(positions.get(selectedCM.getRoleInt()));
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

    public Integer getPositionId() {
        if (roleChoiceBox.getSelectionModel().getSelectedItem() == null) {
            return null;
        }

        String role = roleChoiceBox.getSelectionModel().getSelectedItem().toString();
        int positionId = 0;
        for (int idNum : positions.keySet()){
            if (positions.get(idNum).equals(role)){
                positionId = idNum;
                break;
            }
        }
        return positionId;
    }
}
