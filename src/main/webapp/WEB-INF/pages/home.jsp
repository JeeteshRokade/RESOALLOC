<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESOURCE ALLOCATION TOOL</title>
</head>
<body>
<h2>RESOURCE ALLOsdCATION TOOL</h2>
<p>${userid}</p>
<p>${logged_in }</p>
<p>Create a request</p>
<label>Resource Type</label>
<form action ="home" method="post">
<input type="text" name="resourcetype">
<label>Resource Name</label>
<input type="text" name="resourcename">
<label>Resource Reason</label>
<input type="text" name="resourcereason">
<input type="submit" name="Raise Request">
</form>
<a href="logout">Logout</a>
</br>
<a href="viewreq">View All your Requests</a>
</br>
<a href="logout">Approve Requests</a>

</body>
</html>