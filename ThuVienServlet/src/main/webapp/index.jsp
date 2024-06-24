<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="index.css" />
<title>Login</title>

</head>
<body>
<div class="background-blur"></div>
<div class="login-form">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <div class="input-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" >
        </div>
        <div class="input-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" >
        </div>
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>


