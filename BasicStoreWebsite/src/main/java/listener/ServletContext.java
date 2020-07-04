package listener;

import dao.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebListener
public class ServletContext implements ServletContextListener {

    private final ProductsDatabase productsDatabase;
    private final ProductsDatabaseManager productsDatabaseManager;

    public ServletContext() throws ClassNotFoundException, SQLException {
        productsDatabase = new ProductsDatabase();
        productsDatabaseManager = new ProductsDatabaseManager();
        addProducts();
    }

    private void addProducts() throws SQLException {
        productsDatabaseManager.addProduct(new Product("HLE",    "Limited Edition Hood", "LimitedEdHood.jpg",  54.95));
        productsDatabaseManager.addProduct(new Product("TC",     "Classic Tee",          "TShirt.jpg",         13.95));
        productsDatabaseManager.addProduct(new Product("HC",     "Classic Hoodie",       "Hoodie.jpg",         40.00));
        productsDatabaseManager.addProduct(new Product("TS",     "Seal Tee",             "SealTShirt.jpg",     19.95));
        productsDatabaseManager.addProduct(new Product("TLJa",   "Japanese Tee",         "JapaneseTShirt.jpg", 17.95));
        productsDatabaseManager.addProduct(new Product("TLKo",   "Korean Tee",           "KoreanTShirt.jpg",   17.95));
        productsDatabaseManager.addProduct(new Product("TLCh",   "Chinese Tee",          "ChineseTShirt.jpg",  17.95));
        productsDatabaseManager.addProduct(new Product("TLHi",   "Hindi Tee",            "HindiTShirt.jpg",    17.95));
        productsDatabaseManager.addProduct(new Product("TLAr",   "Arabic Tee",           "ArabicTShirt.jpg",   17.95));
        productsDatabaseManager.addProduct(new Product("TLHe",   "Hebrew Tee",           "HebrewTShirt.jpg",   17.95));
        productsDatabaseManager.addProduct(new Product("AKy",    "Keychain",             "Keychain.jpg",       02.95));
        productsDatabaseManager.addProduct(new Product("ALn",    "Lanyard",              "Lanyard.jpg",        05.95));
        productsDatabaseManager.addProduct(new Product("ATherm", "Thermos",              "Thermos.jpg",        19.95));
        productsDatabaseManager.addProduct(new Product("AMinHm", "Mini Football Helmet", "MiniHelmet.jpg",     29.95));
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("productsDatabaseManager", productsDatabaseManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            productsDatabase.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
