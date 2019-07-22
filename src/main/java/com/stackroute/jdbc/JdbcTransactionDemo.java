package com.stackroute.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class JdbcTransactionDemo {
    public void transactionDemo() {
        //Connection for mysql class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //connection establishment
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
             //Inserting values into the table
             PreparedStatement ps = connection.prepareStatement("insert into employee values(?,?,?,?)");) {
            connection.setAutoCommit(false); //Setting commit as FALSE
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {

                System.out.println("enter id");
                String s1 = br.readLine();
                int employeeId = Integer.parseInt(s1);

                System.out.println("enter name");
                String employeeName = br.readLine();

                System.out.println("enter age");
                String s3 = br.readLine();
                int employeeAge = Integer.parseInt(s3);

                System.out.println("enter gender");
                String gender = br.readLine();

                ps.setInt(1, employeeId);
                ps.setString(2, employeeName);
                ps.setInt(3, employeeAge);
                ps.setString(4, gender);
                ps.executeUpdate();

                System.out.println("commit/rollback");
                String answer = br.readLine();
                //If teh given input is equals to commit then it commits
                if (answer.equals("commit")) {
                    connection.commit();
                }
                //If teh given input is equals to rollback then it rollbacks the performed operation
                if (answer.equals("rollback")) {
                    connection.rollback();
                }
                System.out.println("Want to add more records y/n");
                String ans = br.readLine();
                if (ans.equals("n")) {
                    break;
                }

            }
            connection.commit();
            System.out.println("record successfully saved");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
