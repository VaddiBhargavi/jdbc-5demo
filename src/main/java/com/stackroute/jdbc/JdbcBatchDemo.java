package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {
    public void batchDemo(){
        //Connection for mysql class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Connection establishment
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");)
        {
            connection.setAutoCommit(false);
            Statement stmt=connection.createStatement();
            //Multiple queries are performed Using batch operation
            stmt.addBatch("insert into employee values(190,'batch1',40, 'male')");
            stmt.addBatch("insert into employee values(191,'batch2',50,'male')");
            stmt.executeBatch();//executing the batch
            connection.commit();
            System.out.println("Values added into the employee table by JdbcBatchDemo");
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
