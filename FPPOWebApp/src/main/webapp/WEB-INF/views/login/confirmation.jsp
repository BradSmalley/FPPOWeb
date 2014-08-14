<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Registration Confirmed</title>
	
	
	<script type="text/javascript">
		$( document ).ready(function() {
			
		});
	</script>
	
</head>
<body>

<div class="content">
	<h3>Registration Confirmed</h3>

	<form:form action="logout" >
		<table>
			<tr><td>Username:</td><td>${command.username }</td></tr>

			<tr><td>E-mail:</td><td>${command.email}</td></tr>
			<tr><td>First Name:</td><td>${command.firstname }</td></tr>
			<tr><td>Last Name:</td><td>${command.lastname }</td></tr>
			<tr><td>Address Line 1:</td><td>${command.addressLine1 }</td></tr>
			<tr><td>Address Line 2:</td><td>${command.addressLine2 }</td></tr>
			<tr><td>City:</td><td>${command.city }</td></tr>
			<tr><td>State:</td><td>${command.state }</td></tr>
			<tr><td>Postal Code:</td><td>${command.postalCode }</td></tr>
			<tr><td>Phone Number:</td><td>${command.phoneNumber }</td></tr>
			<tr><td colspan='2'><input name="submit" type="submit" value="Done"/></td></tr>
		</table>
	</form:form>
		
</div>


</body>
</html>
