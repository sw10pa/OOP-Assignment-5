<%@ page contentType="text/html" pageEncoding = "UTF-8" %>

<html>
    <head>
        <title>Create Account</title>
    </head>
    <body>
        <h1>The Name <%= request.getParameter("username") %> is Already In Use</h1>
        <p>Please enter another name and password.</p>
        <form action="create-account" method="POST">
            <label for="username">User Name:</label>
            <input id="username" type="text" name="username" required><br><br>
            <label for="password">Password:</label>
            <input id="password" type="password" name="password" required>
            <button type="submit">Login</button>
        </form>
    </body>
</html>
