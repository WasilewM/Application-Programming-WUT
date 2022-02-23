package com.onibmagairlines.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CredentialsDialogController {
    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    public String getLoginTextFieldValue() {
        return loginTextField.textProperty().getValue();
    }

    public String getPasswordTextFieldValue() {
        return passwordTextField.textProperty().getValue();
    }

}
