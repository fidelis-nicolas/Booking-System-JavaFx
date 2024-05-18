package com.bookingsystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    @FXML
    public Button btnLogin;

    @FXML
    public void openLoginPage()throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/bookingsystem/main.fxml")));
        stage.setScene(new Scene(root, 462, 323));
        stage.setTitle("Login");
    }
}
