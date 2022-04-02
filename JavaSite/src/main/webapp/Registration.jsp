<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Cp1251">
<title>Регистрация</title>
</head>
<body>

<form action="RegistrationServlet" method="POST">
	Введите ваш логин  <input type="text" name="Login"><br>
	Введите ваш пароль  <input type="password" name="Password"><br>
	Введите вашe имя  <input type="text" name="UserName"><br>
	Введите вашу фамилию <input type="text" name="UserSurname"><br>	
	Введите вашу страну  <input type="text" name="UserCountru"><br>
	Введите ваш пол/гендер  <input type="text" name="UserGender"><br>
	Введите ваш телефон  <input type="number" name="UserPhone"><br>
	Введите ваш город  <input type="text" name="UserTown"><br>
	Введите ваш email  <input type="email" name="UserEmail"><br>
	Введите ваш возраст  <input type="number" name="UserAge"><br>
	<button type="submit"> Завершить регистрацию</button>	
</form>

</body>
</html>