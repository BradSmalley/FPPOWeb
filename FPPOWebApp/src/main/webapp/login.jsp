<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	
	
	<script type="text/javascript">
		$( document ).ready(function() {
			
		});
	</script>
	
</head>
<body>

<div class="content">

	<c:if test="${param.error == '1'}">
		<div class="alert alert-danger" role="alert">
        	<strong>Authentication Error</strong>
     	 </div>
	</c:if>
	
	<h3>Sign In</h3>
	<form name='f' action='/web/j_spring_security_check' method='POST'>
		<table>
			<tr><td>Username:</td><td><input type='text' name='j_username' value=''></td></tr>
			<tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr><td></td><td align="right"><input name="submit" type="submit" value="Sign In"/></td></tr>
		</table>
	</form>
	<div style="padding-top: 1em;">	
		<p>Not yet signed up?  <a href="<c:url value="/login/register/" />">Sign Up Here!</a></p>
	</div>
</div>


<script type="text/javascript">
	$("#navbar-signin").addClass("active");
</script>

</body>
</html>
