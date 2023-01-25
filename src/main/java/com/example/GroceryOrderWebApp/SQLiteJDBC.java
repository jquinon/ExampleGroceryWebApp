package com.example.GroceryOrderWebApp;

import java.sql.*;

public class SQLiteJDBC {

    public static void insertOrder(Order o){
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:grocery.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO GROCERY_LIST (ITEM, QUANTITY) " +
                    String.format("VALUES ('%s', %d);", o.item, o.quantity);

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Order saved successfully");
    }

    // Run to create DB and table
    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:grocery.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE GROCERY_LIST " +
                    "(ID INT PRIMARY KEY," +
                    " ITEM           TEXT    NOT NULL, " +
                    " QUANTITY       INT     NOT NULL); ";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("DB and Table created successfully");
    }

}
