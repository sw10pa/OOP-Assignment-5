package servlet;

import dao.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CreateAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/create-account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountManager accountManager = (AccountManager) getServletContext().getAttribute("accountManager");

        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        if(accountManager.accountExists(userName)) {
            req.getRequestDispatcher("/WEB-INF/view/name-in-use.jsp").forward(req, resp);
        } else {
            accountManager.createNewAccount(userName, password);
            req.getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(req, resp);
        }
    }

}
