package com.bookingsystem.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection connnect() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/bookingsystem","root", "Fidelis@123");
                return con;
    }
}
