package servlet;

import java.io.*;
import listener.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute("shoppingCart");

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            req.getSession().setAttribute("shoppingCart", shoppingCart);
        }

        req.getRequestDispatcher("/WEB-INF/view/shopping-cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute("shoppingCart");

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            req.getSession().setAttribute("shoppingCart", shoppingCart);
        }

        String productId = req.getParameter("productId");
        if (productId != null) {
            shoppingCart.addNewProduct(productId);
        } else {
            Enumeration<String> productIds = req.getParameterNames();
            while (productIds.hasMoreElements()) {
                productId = productIds.nextElement();
                int quantity = Integer.parseInt(req.getParameter(productId));
                shoppingCart.changeQuantity(productId, quantity);
            }
        }

        req.getSession().setAttribute("shoppingCart", shoppingCart);
        req.getRequestDispatcher("/WEB-INF/view/shopping-cart.jsp").forward(req, resp);
    }

}
