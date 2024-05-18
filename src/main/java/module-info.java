module com.bookingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.bookingsystem to javafx.fxml;
    exports com.bookingsystem;
    exports com.bookingsystem.controller;
    opens com.bookingsystem.controller to javafx.fxml;
    exports com.bookingsystem.auth;
    opens com.bookingsystem.auth to javafx.fxml;
}