package dao;

public class Product {

    private final String productId;
    private final String name;
    private final String imageFile;
    private final double price;

    public Product(String productId, String name, String imageFile, double price) {
        this.productId = productId;
        this.name = name;
        this.imageFile = imageFile;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getImageFile() {
        return imageFile;
    }

    public double getPrice() {
        return price;
    }

}
