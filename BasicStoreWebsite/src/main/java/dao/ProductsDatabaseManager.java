package dao;

import java.sql.*;
import java.util.*;

public class ProductsDatabaseManager {

    public void addProduct(Product product) throws SQLException {
        PreparedStatement statement = ProductsDatabase.getConnection().prepareStatement(
                "INSERT INTO " + ProductsDatabase.TABLE_NAME + " VALUES (?, ?, ?, ?);");

        statement.setString(1, product.getProductId());
        statement.setString(2, product.getName());
        statement.setString(3, product.getImageFile());
        statement.setDouble(4, product.getPrice());

        statement.execute();
        statement.close();
    }

    public Product getProduct(String productId) throws SQLException {
        Statement statement = ProductsDatabase.getConnection().createStatement();
        String query = "SELECT * FROM " + ProductsDatabase.TABLE_NAME + " WHERE productid = '" + productId + "';";

        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        return buildProduct(resultSet);
    }

    public ArrayList<Product> getAllProducts() throws SQLException {
        Statement statement = ProductsDatabase.getConnection().createStatement();
        String query = "SELECT * FROM " + ProductsDatabase.TABLE_NAME + ";";

        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Product> products = new ArrayList<>();

        while (resultSet.next()) {
            products.add(buildProduct(resultSet));
        }

        return products;
    }

    private Product buildProduct(ResultSet resultSet) throws SQLException {
        return new Product(resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getDouble(4));
    }

}
