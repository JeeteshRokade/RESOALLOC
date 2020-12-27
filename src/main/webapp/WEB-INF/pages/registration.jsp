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
<form action="registration" method="post"  >
<label>UserID</label>
<input type="text" name="userid">
<br/>
<label>Firstname</label>
<input type="text" name="fname">
<br/>
<label>Middlename</label>
<input type="text" name="mname">
<br/>
<label>Lastname</label>
<input type="text" name="lname">
<br/>
<label>City</label>
<input type="text" name="city">
<br/>
<label>Country</label>
<input type="text" name="country">
<br/>
<label>ManagerID</label>
<input type="text" name="managerid">
<br/>
<label>Are you a manager?</label>
<label>yes</label>
<input type="radio" name="role" value="yes">
<label>no</label>
<input type="radio" name="role" value = "no">
<br/>
<label>Password</label>
<input type="password" name="password">
<input type="submit">
</form>
<p>${userpresent}</p>
</body>
</html>