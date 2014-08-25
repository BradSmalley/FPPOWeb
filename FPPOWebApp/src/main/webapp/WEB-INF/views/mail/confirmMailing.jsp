<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 			prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"	prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring" %>


<%@ page session="false" %>
<html>
<head>
	<title>Mailing Confirmed</title>
</head>
<body>

<div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div>

<div class="content">

	<h2>Mailing has been sent.</h2>
	
	<p>The following will receive your message:</p>
	
	<table id="userList">
		<thead>
			<tr>
				<th>Username</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.email}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<input type="button" class="btn btn-cancel" value="Done" onclick="window.location ='<c:url value="/admin"/>';"/>
	
</div>
	<script>
	
		$(document).ready(function() {
			
			$("#userList").dataTable();
			
		});
	
	</script>


</body>
</html>
