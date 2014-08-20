<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form"	prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring" %>


<%@ page session="false" %>
<html>
<head>
	<title>Members: Edit Basic Information</title>
	
	<script type="text/javascript">
		$( document ).ready(function() {
			
		});
	</script>
	
</head>
<body>

<div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div>

<div class="content">


	<spring:hasBindErrors name="editBasicInfoForm">
		<div class="alert alert-danger" role="alert">
			<h3>Errors:</h3>
			<ul>
				<c:forEach items="${errors.allErrors}" var="error">
					<li>${error.defaultMessage}</li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

	<form:form commandName="editBasicInfoForm" method="POST" cssClass="form-horizontal">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-10">
				<p class="form-control-static">${editBasicInfoForm.username}</p>
				<form:hidden path="username" name="username" />
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">First Name</label>
			<div class="col-sm-10">
				<form:input path="firstname" name="firstname" cssClass="form-control" maxlength="45"/>
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-10">
				<form:input path="lastname" name="lastname" cssClass="form-control" maxlength="45"/>
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<form:input path="email" name="email" cssClass="form-control" maxlength="100"/>
			</div>
		</div>
	
		<!-- div class="fields">
			<div class="formField"><label for="username">Username: </label><form:input path="username" name="username" /></div>
			<div class="formField"><label for="firstname">First Name: </label><form:input path="firstname" name="firstname" /></div>
			<div class="formField"><label for="lastname">Last Name: </label><form:input path="lastname" name="lastname" /></div>
			<div class="formField"><label for="email">Email: </label><form:input path="email" name="email" /></div>
		</div -->
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10" >
				<input type="submit" class="btn btn-default" value="Save Changes" />
			</div>
		</div>
		
	</form:form>

</div>


</body>
</html>
