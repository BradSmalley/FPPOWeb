<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 			prefix="fmt" %>
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


	<spring:hasBindErrors name="adminEditBasicInfoForm">
		<div class="alert alert-danger" role="alert">
			<h3>Errors:</h3>
			<ul>
				<c:forEach items="${errors.allErrors}" var="error">
					<li>${error.defaultMessage}</li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

	<form:form commandName="adminEditBasicInfoForm" method="POST" cssClass="form-horizontal">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-10">
				<p class="form-control-static">${adminEditBasicInfoForm.username}</p>
				<form:hidden path="username" name="username" />
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<form:input path="email" name="email" cssClass="form-control" maxlength="100"/>
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
			<label for="lastname" class="col-sm-2 control-label">Registration Date</label>
			<div class="col-sm-10">
				<p class="form-control-static"><fmt:formatDate value="${adminEditBasicInfoForm.registrationDate}" dateStyle="SHORT"/></p>
				<form:hidden path="registrationDate" name="registrationDate"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label>
						<form:checkbox path="paid" name="paid" /> Paid
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="datePaid" class="col-sm-2 control-label">Date Paid</label>
			<div class="col-sm-10">
				<form:input path="lastPaymentDate" name="lastPaymentDate" cssClass="form-control" maxlength="45"/>
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
