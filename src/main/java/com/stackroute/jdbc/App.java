package com.stackroute.jdbc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SimpleJdbcDemo simpleJdbcDemo= new SimpleJdbcDemo();
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("Printing employee details in reverse order");
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        System.out.println("printing employee details from specified row");
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("based on gender and name");
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("bhargavi","female");
        System.out.println("Printing ResultSetMetaDataDemo");
        //ResultSetMetaDataDemo contains Column Types, Column Name
        ResultSetMetaDataDemo resultSetMetaDataDemo= new ResultSetMetaDataDemo();
        resultSetMetaDataDemo.resultSetDemo();
        //JdbcTransactionDemo performs commit/rollback
        System.out.println("-----Printing JdbcTransactionDemo-----");
        //JdbcTransactionDemo jdbcTransactionDemo= new JdbcTransactionDemo();
        //jdbcTransactionDemo.transactionDemo();
        //DatabaseSetMetaDataDemo
        System.out.println("-----Printing DatabaseSetMetaDataDemo-----");
        DatabaseSetMetaDataDemo databaseSetMetaDataDemo= new DatabaseSetMetaDataDemo();
        databaseSetMetaDataDemo.getDatabaseMetaData();
        //JdbcBatchDemo
        System.out.println("-----Printing JdbcBatchDemo-----");
        JdbcBatchDemo jdbcBatchDemo= new JdbcBatchDemo();
        jdbcBatchDemo.batchDemo();
        //RowsetDemo
        System.out.println("----RowSetDemo----");
        RowSetDemo rowSetDemo= new RowSetDemo();
        rowSetDemo.rowSet();
    }
}
