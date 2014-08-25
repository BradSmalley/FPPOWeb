<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
</head>
<body>

<div class="content">

	<c:if test="${param.error == '1'}">
		<div class="alert alert-danger" role="alert">
        	<strong>Authentication Error</strong>
     	 </div>
	</c:if>
	
	<h3>Sign In</h3>
	<form name='f' action='<c:url value="/j_spring_security_check" />' method='POST' class="form-horizontal">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-10">
				<input type="text" name="j_username" class="form-control" placeholder="Username" />
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" name="j_password" class="form-control" placeholder="Password" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input name="submit" type="submit" value="Sign In" class="btn btn-default" />
			</div>
		</div>
		<p>Not yet signed up?  <a href="<c:url value="/login/register/" />">Sign Up Here!</a></p>
	</form>
</div>

<script type="text/javascript">
	$("#navbar-signin").addClass("active");
</script>

</body>
</html>
