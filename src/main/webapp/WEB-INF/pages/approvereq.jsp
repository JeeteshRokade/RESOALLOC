<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESOURCE ALLOCATION TOOL</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<h2>RESOURCE ALLOsdCATION TOOL</h2>
	<p>${userid}</p>

	<table border="1">
		<th>REASON</th>
		<th>USER</th>
		<th>APPROVER</th>
		<th>RESOURCE TYPE</th>
		<th>RESOURCE NAME</th>
		<th>STATUS</th>
		<th>APPROVE/REJECT</th>
		<c:forEach items="${requestlist}" var="req">


			<tr>
				<td>${req.requestreason}</td>
				<td>${req.user}</td>
				<td>${req.approver}</td>
				<td>${req.resource.resourcedetails.resourcetype}</td>
				<td>${req.resource.resourcedetails.resourcename}</td>
				<td>${req.status}</td>
				<td><input type="submit" name="approve" value="Approve"
					onclick="approvefun(<c:out value='${req.requestid}'/>,<c:out value='${req.resource.resourceid}'/>,'<c:out value='${req.user}'/>')">
					<input type="submit" name="reject" value="Reject"
					onclick="rejectfun(<c:out value='${req.requestid}'/>,<c:out value='${req.resource.resourceid}'/>,'<c:out value='${req.user}'/>')">
					</td>
			</tr>
			</br>
			<script type="text/javascript">
function approvefun(requestid,resourceid,userid)
{
	alert(requestid);

	$.ajax({
	    type: 'POST',
	    // make sure you respect the same origin policy with this url:
	    // http://en.wikipedia.org/wiki/Same_origin_policy
	    url: 'changestatus',
	    data: { 
	        'requestid':requestid,
	        'resourceid':resourceid,
	        'status':'Approved',
	        'userid':userid
	    },
	    success: function(){
	    	alert('Request approved');
	    }
	});
	
	}

function rejectfun(requestid,resourceid,userid)
{
	

	$.ajax({
	    type: 'POST',
	    // make sure you respect the same origin policy with this url:
	    // http://en.wikipedia.org/wiki/Same_origin_policy
	    url: 'changestatus',
	    data: { 
	        'requestid':requestid,
	        'resourceid':resourceid,
	        'status':'Rejected',
	        'userid':userid
	    },
	    success: function(){
	    	alert('Request rejected');
	    }
	});
	
	}
</script>

		</c:forEach>
	</table>



</body>
</html>