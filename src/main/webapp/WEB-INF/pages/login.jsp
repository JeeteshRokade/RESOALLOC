<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESOURCE ALLOCATION</title>
</head>
<body>
<form action="login" method=post  >
<label>Username</label>
<input type="text" name="userid">
<label>Password</label>
<input type="password" name="pass">
<input type="submit">
<a href ="registration"> Register </a>
<p>${badcred}</p>
</form>
</body>
</html>