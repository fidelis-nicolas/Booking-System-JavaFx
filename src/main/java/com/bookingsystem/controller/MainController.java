package com.bookingsystem.controller;

import com.bookingsystem.connect.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class MainController {
    @FXML
    TextField txt_email;
    @FXML
    PasswordField txt_password;

    @FXML
    Button btnRegister;
    @FXML
    Button btn_login;

    @FXML
    protected void openRegistrationScreen() throws IOException {
        Stage stage = (Stage) btnRegister.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/bookingsystem/register.fxml")));
        stage.setScene(new Scene(root, 707, 624));
        stage.setTitle("Registration");
    }
    @FXML
    public void customerLogin()throws IOException{
        try {

            String email = txt_email.getText();
            String password = txt_password.getText();

            if (login(email, password)){
                Stage stage = (Stage) btn_login.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/bookingsystem/customerDashboard.fxml")));
                stage.setScene(new Scene(root, 707, 624));
                stage.setTitle("Registration");
            }
            else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("Invalid Login details");
                error.show();

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean login(String email, String password)throws SQLException{

        boolean login = false;
        Connection con = DBConnect.connnect();


        String sql = "select email, password from customers where email =? and password = ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,email);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            login = true;
        }

        return login;
    }
}