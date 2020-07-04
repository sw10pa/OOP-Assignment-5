<%@ page contentType="text/html" pageEncoding = "UTF-8" %>

<html>
    <head>
        <title>Welcome <%= request.getParameter("username") %></title>
    </head>
    <body>
        <h1>Welcome <%= request.getParameter("username") %></h1>
    </body>
</html>
