package com.stackroute.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseSetMetaDataDemo {
    public void getDatabaseMetaData() {
        //Connection for mysql class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Connection establishment
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");){
             DatabaseMetaData dbmd=connection.getMetaData();
             //Retrieving data of the database
            System.out.println("Driver Name: "+dbmd.getDriverName());
            System.out.println("Driver Version: "+dbmd.getDriverVersion());
            System.out.println("UserName: "+dbmd.getUserName());
            System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}