package listener;

import java.util.*;

public class ShoppingCart {

    private final HashMap<String, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public void addNewProduct(String productId) {
        if (!cart.containsKey(productId)) {
            cart.put(productId, 1);
        } else {
            cart.put(productId, getQuantity(productId) + 1);
        }
    }

    public int getQuantity(String productId) {
        return cart.get(productId);
    }

    public void changeQuantity(String productId, int quantity) {
        if (quantity <= 0) {
            cart.remove(productId);
        } else {
            cart.put(productId, quantity);
        }
    }

    public Set<String> getAddedProducts() {
        return cart.keySet();
    }

}
