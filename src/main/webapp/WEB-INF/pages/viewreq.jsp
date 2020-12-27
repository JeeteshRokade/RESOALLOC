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
<table border="1">
<c:forEach items="${requestlist}" var="req">


    <tr>      
        <td>${req.requestreason}</td>
        <td>${req.status}</td>
        <td>${req.user}</td>
        <td>${req.approver}</td>
        <td>${req.resource.resourcedetails.resourcetype}</td>  
    </tr>
    </br>
   
</c:forEach>
</table>
</body>
</html>