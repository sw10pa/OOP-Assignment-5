<%@ page import="dao.*" %>
<%@ page import="listener.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html" pageEncoding = "UTF-8" %>

<html>
    <head>
        <% ProductsDatabaseManager productsDatabaseManager = (ProductsDatabaseManager) request.getServletContext().getAttribute("productsDatabaseManager"); %>
        <% ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("shoppingCart"); %>
        <% Set<String> addedProductsIds = cart.getAddedProducts(); %>
        <% Set<Product> addedProducts = new HashSet<Product>(); %>
        <% for (String productId : addedProductsIds) { %>
            <% Product product = productsDatabaseManager.getProduct(productId); %>
            <% addedProducts.add(product); %>
        <% } %>
        <% double totalResult = 0; %>
        <% for (Product product : addedProducts) { %>
            <% totalResult += (product.getPrice() * cart.getQuantity(product.getProductId())); %>
        <% } %>
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Shopping Cart</h1>
        <form action="shopping-cart" method="POST">
        <ul>
            <% for(Product product : addedProducts) { %>
                <li>
                    <input type="number" value="<%= cart.getQuantity(product.getProductId()) %>" name="<%= product.getProductId() %>">
                    <%= product.getName() %>, <%= product.getPrice() %>
                </li>
            <% } %>
        </ul>
            Total: $<%= totalResult %>
            <button type="submit">Update Cart</button>
        </form>
        <a href="homepage">Continue Shopping</a>
    </body>
</html>
