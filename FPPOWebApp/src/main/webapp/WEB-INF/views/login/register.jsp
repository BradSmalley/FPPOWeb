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
	
	<form:form cssClass="form-horizontal" role="form">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-10">
				<form:input path="username" type="text" name="username" cssClass="form-control" placeholder="Username" />
			</div>
		</div>
		<div class="form-group">
			<label for="Password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<form:input path="password" type="text" name="password" cssClass="form-control" placeholder="Password" />
			</div>
		</div>
		<div class="form-group">
			<label for="retypePassword" class="col-sm-2 control-label">Confirm Password</label>
			<div class="col-sm-10">
				<form:input path="retypePassword" type="text" name="retypePassword" cssClass="form-control" placeholder="Confirm Password" />
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<form:input path="email" type="text" name="email" cssClass="form-control" placeholder="Email" />
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">First Name</label>
			<div class="col-sm-10">
				<form:input path="firstname" type="text" name="firstname" cssClass="form-control" placeholder="First Name" />
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-10">
				<form:input path="lastname" type="text" name="lastname" cssClass="form-control" placeholder="Last Name" />
			</div>
		</div>
		<div class="form-group">
			<label for="addressLine1" class="col-sm-2 control-label">Address Line 1</label>
			<div class="col-sm-10">
				<form:input path="addressLine1" type="text" name="addressLine1" cssClass="form-control" placeholder="Address Line 1" />
			</div>
		</div>
		<div class="form-group">
			<label for="addressLine2" class="col-sm-2 control-label">Address Line 2</label>
			<div class="col-sm-10">
				<form:input path="addressLine2" type="text" name="addressLine2" cssClass="form-control" placeholder="Address Line 2" />
			</div>
		</div>
		<div class="form-group">
			<label for="city" class="col-sm-2 control-label">City</label>
			<div class="col-sm-10">
				<form:input path="city" type="text" name="city" cssClass="form-control" placeholder="City" />
			</div>
		</div>
		<div class="form-group">
			<label for="state" class="col-sm-2 control-label">State</label>
			<div class="col-sm-10">
				<form:input path="state" type="text" name="state" cssClass="form-control" placeholder="State" />
			</div>
		</div>
		<div class="form-group">
			<label for="postalCode" class="col-sm-2 control-label">Postal Code</label>
			<div class="col-sm-10">
				<form:input path="postalCode" type="text" name="postalCode" cssClass="form-control" placeholder="Postal Code" />
			</div>
		</div>
		
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input name="submit" type="submit" value="Sign Up" class="btn btn-default" />
			</div>
		</div>
		<!-- table>
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
			<input name="submit" type="submit" value="Sign Up" class="btn btn-default" />
		</table -->
	</form:form>
</div>


<script type="text/javascript">
	$("#navbar-signup").addClass("active");
</script>


</body>
</html>
