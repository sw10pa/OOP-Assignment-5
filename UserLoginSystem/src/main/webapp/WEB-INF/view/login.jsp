<%@ page contentType="text/html" pageEncoding = "UTF-8" %>

<html>
    <head>
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome to Homework 5</h1>
        <p>Please log in.</p>
        <form action="login" method="POST">
            <label for="username">User Name:</label>
            <input id="username" type="text" name="username" required><br><br>
            <label for="password">Password:</label>
            <input id="password" type="password" name="password" required>
            <button type="submit">Login</button>
        </form>
        <a href="create-account">Create New Account</a>
    </body>
</html>
