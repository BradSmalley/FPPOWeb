<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form"	prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring" %>


<%@ page session="false" %>
<html>
<head>
	<title>Members: Edit Phone Information</title>
	
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


	<spring:hasBindErrors name="editPhoneInfoForm">
		<div class="alert alert-danger" role="alert">
			<h3>Errors:</h3>
			<ul>
				<c:forEach items="${errors.allErrors}" var="error">
					<li>${error.defaultMessage}</li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

	<form:form commandName="editPhoneInfoForm" action="save" method="POST" cssClass="form-horizontal">
		<div class="form-group">
			<label for="phoneNumber" class="col-sm-2 control-label">Phone Number</label>
			<div class="col-sm-10">
				<form:input path="phoneNumber" name="phoneNumber" cssClass="form-control"/>
			</div>
		</div>
		<div class="form-group">
			<label for="extension" class="col-sm-2 control-label">Extension</label>
			<div class="col-sm-10">
				<form:input path="extension" name="extension" cssClass="form-control"/>
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
