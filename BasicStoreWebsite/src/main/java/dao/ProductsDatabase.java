package dao;

import java.sql.*;

public class ProductsDatabase {

    public static final String DATABASE_NAME = "OOP";
    public static final String TABLE_NAME = "products";

    private static Connection connection;

    public ProductsDatabase() throws ClassNotFoundException, SQLException {
        openConnection();
        createDatabase();
        createTable();
    }

    public static Connection getConnection() {
        return connection;
    }

    private void openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Stephane27");
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    private void createDatabase() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DROP DATABASE IF EXISTS " + DATABASE_NAME + ";");
        statement.execute("CREATE DATABASE " + DATABASE_NAME + ";");
        statement.execute("USE " + DATABASE_NAME + ";");
    }

    private void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        statement.execute("CREATE TABLE " + TABLE_NAME +
                "(productid CHAR(6)," +
                " name CHAR(64)," +
                " imagefile CHAR(64)," +
                " price DECIMAL(6,2));");
    }

}
