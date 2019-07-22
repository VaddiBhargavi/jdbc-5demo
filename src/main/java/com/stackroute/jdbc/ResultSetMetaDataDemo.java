package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetaDataDemo {
    public void resultSetDemo(){
        //Connection for mysql class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Connection establishement
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //Retrieveing data of the table
            System.out.println("Total columns: " + rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
