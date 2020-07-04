<%@ page import="dao.*" %>
<%@ page contentType="text/html" pageEncoding = "UTF-8" %>

<html>
    <head>
        <% ProductsDatabaseManager productsDatabaseManager = (ProductsDatabaseManager) request.getServletContext().getAttribute("productsDatabaseManager"); %>
        <% Product product = productsDatabaseManager.getProduct(request.getParameter("productId")); %>
        <title><%= product.getName() %></title>
    </head>
    <body>
        <h1><%= product.getName() %></h1>
        <img src="/store-images/<%= product.getImageFile() %>" alt="<%= product.getName() %>" width="200" height="200"><br>
        <form action="shopping-cart" method="POST">
            $<%= product.getPrice() %>
            <input name="productId" type="hidden" value="<%= product.getProductId() %>"/>
            <button type="submit">Add to Cart</button>
        </form>
    </body>
</html>
