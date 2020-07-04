package listener;

import dao.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebListener
public class ServletContext implements ServletContextListener {

    private final AccountManager accountManager;

    public ServletContext() {
        accountManager = new AccountManager();
    }

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("accountManager", accountManager);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

}
