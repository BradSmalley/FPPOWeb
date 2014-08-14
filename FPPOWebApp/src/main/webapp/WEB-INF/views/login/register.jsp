<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Registration Form</title>
</head>
<body>

<div class="content">
	<h3>Registration Form</h3>
	
	<spring:hasBindErrors name="registrationForm">
		<div class="alert alert-danger" role="alert">
			<h3>Errors:</h3>
			<ul>
				<c:forEach items="${errors.allErrors}" var="error">
					<li>${error.defaultMessage}</li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>
	
	<form:form>
		<table>
			<tr><td>Username:</td><td><form:input path="username" type="text" name="username" /></td></tr>
			<tr><td>Password:</td><td><form:password path="password" name='password' /></td></tr>
			<tr><td>Confirm Password:</td><td><form:password path="retypePassword" name='retypePassword' /></td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td>First Name:</td><td><form:input path="firstname" type='text' name='firstname' /></td></tr>
			<tr><td>Last Name:</td><td><form:input path="lastname" type='text' name='lastname' /></td></tr>
			<tr><td>E-mail:</td><td><form:input path="email" type='text' name='email' /></td></tr>
			<tr><td>Address Line 1:</td><td><form:input path="addressLine1" type='text' name='addressLine1' /></td></tr>
			<tr><td>Address Line 2:</td><td><form:input path="addressLine2" type='text' name='addressLine2' /></td></tr>
			<tr><td>City:</td><td><form:input path="city" type='text' name='city' /></td></tr>
			<tr><td>State:</td><td><form:input path="state" type='text' name='state' /></td></tr>
			<tr><td>Postal Code:</td><td><form:input path="postalCode" type='text' name='postalCode' /></td></tr>
			<tr><td>Phone Number:</td><td><form:input path="phoneNumber" type='text' name='phoneNumber' /></td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td></td><td align="right"><input name="submit" type="submit" value="Sign Up"/></td></tr>
		</table>
	</form:form>
</div>


<script type="text/javascript">
	$("#navbar-signup").addClass("active");
</script>


</body>
</html>
