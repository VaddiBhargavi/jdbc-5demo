package com.stackroute.jdbc;

import java.sql.*;

public class SimpleJdbcDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public void getEmployeeDetails(){
        /*Load driver and register with Drivermanager*/
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Root@123");
        Statement statement= connection.createStatement();
       ResultSet resultSet= statement.executeQuery("Select * from employee");) {
            while (resultSet.next())
            {
                System.out.println("Id: "+resultSet.getInt(1)+"Name: "+resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        public void getEmployeeDetailsInReverse()
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Root@123");
                Statement statement= connection.createStatement();
                ResultSet resultSet= statement.executeQuery("Select * from employee");) {
                resultSet.afterLast(); //Pointer result to the last record
                while (resultSet.previous()) //From last record it gives the data in reverse order
                {
                    System.out.println("Id: "+resultSet.getInt(1)+"Name: "+resultSet.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            }
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {
            resultSet.absolute(2); //Pointer points to the second row
            while (resultSet.previous()) //From second record it gives the data in reverse order
            {
                System.out.println("Id: "+resultSet.getInt(1)+"Name: "+resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getEmployeeDetailsByNameAndGender(String employeeName,String gender) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            String q="Select * from employee where employeeName='"+employeeName+"' and gender='"+gender+"'";
            ResultSet rs=statement.executeQuery(q);
            //Retrieving data based on name and gender
            if(rs.next())
            {
                System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
            }
            else
            {
                System.out.println("Record Not Found...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
