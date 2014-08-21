<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 			prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"	prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring" %>


<%@ page session="false" %>
<html>
<head>
	<title>Create Mailing</title>
</head>
<body>

<div class="jumbotron">
	<h1>FPPO</h1>
	<p>The Fictitious Professional's Professional Organization</p>
</div>

<div class="content">

	<c:if test="${success}">
		<div>
			<h1>Success!</h1>
		</div>
	</c:if>

	<spring:hasBindErrors name="createMailingForm">
		<div class="alert alert-danger" role="alert">
			<h3>Errors:</h3>
			<ul>
				<c:forEach items="${errors.allErrors}" var="error">
					<li>${error.defaultMessage}</li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

	<form:form commandName="createMailingForm" method="POST" cssClass="form-horizontal">
		<div class="form-group">
			<label for="subject" class="col-sm-2 col-md-2 col-lg-10 control-label">Subject</label>
			<div class="col-sm-10 col-md-10 col-lg-10">
				<form:input path="subject" name="subject" />
			</div>
		</div>
		<div class="form-group">
			<label for="message" class="col-sm-2 control-label">Message</label>
			<div class="col-sm-10">
				<form:textarea path="message" name="message" cssClass="form-control" rows="10" />
			</div>
		</div>
		<div class="form-group">
			<label for="audience" class="col-sm-2 control-label">Audience</label>
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label>
						<form:checkbox path="paid" name="paid" /> Paid
					</label>
				</div>
				<div class="checkbox">
					<label>
						<form:checkbox path="nonPaid" name="nonPaid" /> Non-Paid
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10" >
				<input type="submit" class="btn btn-default" value="Send" />
				<input type="button" class="btn btn-cancel" value="Cancel" onclick="window.location('<c:url value="/admin"/>');"/>
			</div>
		</div>
		
	</form:form>

</div>


</body>
</html>
