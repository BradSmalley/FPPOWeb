<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form"	prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring" %>


<%@ page session="false" %>
<html>
<head>
	<title>Edit Role Information</title>
</head>
<body>

<div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div>

<div class="content">


	<spring:hasBindErrors name="editRoleInfoForm">
		<div class="alert alert-danger" role="alert">
			<h3>Errors:</h3>
			<ul>
				<c:forEach items="${errors.allErrors}" var="error">
					<li>${error.defaultMessage}</li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

	<form:form commandName="editRoleInfoForm" method="POST" cssClass="form-horizontal">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label>
						<form:checkbox path="admin" name="admin" /> Admin
					</label>
				</div>
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
