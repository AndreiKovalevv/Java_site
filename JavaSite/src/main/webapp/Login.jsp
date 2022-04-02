<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Логин/Авторизация</title>
</head>
<body>
<form action="LoginServlet" method="POST">
Введите ваш логин  <input type="text" name="Login"><br>
Введите ваш пароль  <input type="password" name="Password"><br>
<button type="submit"> Вход</button>	
</form>
</body>
</html>