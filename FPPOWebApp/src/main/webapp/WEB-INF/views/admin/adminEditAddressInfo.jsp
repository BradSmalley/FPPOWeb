<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form"	prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring" %>


<%@ page session="false" %>
<html>
<head>
	<title>Edit Address Information</title>
</head>
<body>

<div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div>

<div class="content">

	<spring:hasBindErrors name="editAddressInfoForm">
		<div class="alert alert-danger" role="alert">
			<h3>Errors:</h3>
			<ul>
				<c:forEach items="${errors.allErrors}" var="error">
					<li>${error.defaultMessage}</li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

	<form:form commandName="editAddressInfoForm" method="POST" cssClass="form-horizontal">
		<div class="form-group">
			<label for="addressLine1" class="col-sm-2 control-label">Address Line 1</label>
			<div class="col-sm-10">
				<form:input path="addressLine1" name="addressLine1" cssClass="form-control" maxlength="200"/>
			</div>
		</div>
		<div class="form-group">
			<label for="addressLine2" class="col-sm-2 control-label">Address Line 2</label>
			<div class="col-sm-10">
				<form:input path="addressLine2" name="addressLine2" cssClass="form-control" maxlength="200"/>
			</div>
		</div>
		<div class="form-group">
			<label for="city" class="col-sm-2 control-label">City</label>
			<div class="col-sm-10">
				<form:input path="city" name="city" cssClass="form-control" maxlength="45" />
			</div>
		</div>
		<div class="form-group">
			<label for="state" class="col-sm-2 control-label">State</label>
			<div class="col-sm-10">
				<form:input path="state" name="state" cssClass="form-control" maxlength="45" />
			</div>
		</div>
		<div class="form-group">
			<label for="postalCode" class="col-sm-2 control-label">Postal Code</label>
			<div class="col-sm-10">
				<form:input path="postalCode" name="postalCode" cssClass="form-control" maxlength="10"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10" >
				<input type="submit" class="btn btn-default" value="Save Changes" />
			</div>
		</div>
	</form:form>
</div>
</body>
</html>
