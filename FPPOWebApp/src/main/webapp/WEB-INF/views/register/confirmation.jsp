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

	<form:form action="<c:url value="/login.jsp" />" cssClass="form-horizontal" role="form">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-10">
				${user.username}
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				${user.email}
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">First Name</label>
			<div class="col-sm-10">
				${user.firstname}
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-10">
				${user.lastname}
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input name="submit" type="submit" value="Sign In" class="btn btn-default" />
			</div>
		</div>
	</form:form>
		
</div>


</body>
</html>
