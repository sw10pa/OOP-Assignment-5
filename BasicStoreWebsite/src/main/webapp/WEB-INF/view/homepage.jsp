<%@ page import="dao.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding = "UTF-8" %>

<html>
    <head>
        <title>Student Store</title>
    </head>
    <body>
        <h1>Student Store</h1>
        <p>Items available:</p>
    <ul>
        <% ProductsDatabaseManager productsDatabaseManager = (ProductsDatabaseManager) request.getServletContext().getAttribute("productsDatabaseManager"); %>
        <% ArrayList<Product> products = productsDatabaseManager.getAllProducts(); %>
        <% for (Product product : products) { %>
        <li><a href="show-product?productId=<%= product.getProductId() %>"><%= product.getName() %></a></li>
        <% } %>
    </ul>
    </body>
</html>
